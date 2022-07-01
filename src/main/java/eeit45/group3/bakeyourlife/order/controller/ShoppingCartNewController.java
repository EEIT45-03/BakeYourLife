package eeit45.group3.bakeyourlife.order.controller;

import eeit45.group3.bakeyourlife.coupon.service.CouponService;
import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductService;
import eeit45.group3.bakeyourlife.good.model.Goods;
import eeit45.group3.bakeyourlife.good.service.GoodService;
import eeit45.group3.bakeyourlife.order.constant.OrderStatus;
import eeit45.group3.bakeyourlife.order.constant.PayType;
import eeit45.group3.bakeyourlife.order.dto.Cart;
import eeit45.group3.bakeyourlife.order.model.CartItem;
import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.model.OrderItem;
import eeit45.group3.bakeyourlife.order.service.OrderService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@SessionAttributes(value = {"cart"})
public class ShoppingCartNewController {
    private OrderService orderService;

    private GoodService goodService;

    private UserService userService;

    private CouponService couponService;

    private FarmerProductService farmerProductService;

    @Autowired
    public ShoppingCartNewController(OrderService orderService,
                                     GoodService goodService,
                                     UserService userService,
                                     CouponService couponService,
                                     FarmerProductService farmerProductService) {
        this.orderService = orderService;
        this.goodService = goodService;
        this.userService = userService;
        this.couponService = couponService;
        this.farmerProductService = farmerProductService;
    }

    @GetMapping("/Cart")
    public String viewCart(Model model,
                           @ModelAttribute Cart cart) {
        List<Goods> goods = goodService.getAllGoods();
        model.addAttribute("goods", goods);
        return "order/Cart";
    }

    @GetMapping("/Cart/Add")
    public String cartAdd(@RequestParam Integer itemId,
                          @RequestParam String type,
                          @ModelAttribute Cart cart) {
        CartItem cartItem = null;
        switch (type){
            case "G":
                cartItem = goodService.getGoods(itemId);
                break;
            case "F":
//                cartItem = farmerProductService.findById(itemId);
                break;
        }

        if(cartItem!=null){
            cart.addItem(cartItem);
        }
        return "order/CartBody";
    }

    @GetMapping("/Cart/Remove")
    public String cartRemove(@RequestParam String itemNo,
//                             @RequestParam String type,
                             @ModelAttribute Cart cart) {
        CartItem cartItem = null;
        String type = itemNo.substring(0,1);
        Integer itemId = Integer.valueOf(itemNo.substring(1));
        switch (type){
            case "G":
                cartItem = goodService.getGoods(itemId);
                break;
            case "F":
//                cartItem = farmerProductService.findById(itemId);
                break;
        }

        if(cartItem!=null){
            cart.removeItem(cartItem.getCartNo());
        }
        return "order/CartBody";
    }


    @GetMapping("/Cart/Update")
    public String cartUpdate(@RequestParam String itemNo,
//                             @RequestParam String type,
                             @RequestParam Integer qty,
                             @ModelAttribute Cart cart) {
        CartItem cartItem = null;
        String type = itemNo.substring(0,1);
        Integer itemId = Integer.valueOf(itemNo.substring(1));
        switch (type){
            case "G":
                cartItem = goodService.getGoods(itemId);
                break;
            case "F":
//                cartItem = farmerProductService.findById(itemId);
                break;
        }

        if(cartItem!=null){
            cart.updataItem(cartItem.getCartNo(),qty);
        }
        return "order/CartBody";
    }


    @GetMapping("CheckOut")
    public String viewCheckOut(@ModelAttribute("cart") Cart cart,
                               Model model, Principal principal) {
        User user = userService.findByUserName(principal.getName());
        model.addAttribute("address", user.getAddress());
        return "order/CheckOut";
    }



    @PostMapping(path = "/CheckOut",produces = "text/html;charset=UTF-8")
    public ResponseEntity<String> checkOut(@ModelAttribute("cart") Cart cart,
                                           @RequestParam String address,
                                           @RequestParam PayType payType,
                                           HttpServletRequest request,
                                           SessionStatus status,
                                           Principal principal) {
        String baseURL = request.getRequestURL().substring(0, request.getRequestURL().length() - request.getRequestURI().length()) + request.getContextPath();
        String orderNo = null;
        if(cart!=null) {
            Order order = new Order();

            //設定訂單編號
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            Date current = new Date();
            int end = (int) (Math.random()*10);
            order.setOrderNo(df.format(current) + end);
            orderNo = order.getOrderNo();
            order.setOrderDate(current);

            //訂單狀態
            order.setOrderStatus(OrderStatus.WAIT_PAYMENT);

            order.setPayType(payType);


//			User user = (User) request.getSession().getAttribute("user");
            User user = userService.findByUserName(principal.getName());


            order.setUser(user);
            order.setAddress(address);
//            order.setOrderType("一般商品");

            order.setShippingFee(cart.getShippingFee());

            order.setOrderItemList(new LinkedHashSet<>(cart.getCart().values()));

            order.getOrderItemList().forEach((e) -> e.setOrder(order));

            order.setTotalPrice(cart.getTotal());

            orderService.createOrder(order);

            status.setComplete();

        }
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(baseURL+"/Order/" + orderNo + "/Pay")).build();
    }


    @ModelAttribute
    public Cart cart(@ModelAttribute Cart cart){
        if(cart == null){
            return new Cart();
        }
        return cart;
    }



}
