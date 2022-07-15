package eeit45.group3.bakeyourlife.order.controller;

import eeit45.group3.bakeyourlife.coupon.model.Coupon;
import eeit45.group3.bakeyourlife.coupon.service.CouponService;
import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.service.FarmerProductService;
import eeit45.group3.bakeyourlife.good.model.Goods;
import eeit45.group3.bakeyourlife.good.service.GoodService;
import eeit45.group3.bakeyourlife.order.constant.OrderStatus;
import eeit45.group3.bakeyourlife.order.constant.PayType;
import eeit45.group3.bakeyourlife.order.model.Cart;
import eeit45.group3.bakeyourlife.order.model.CartItem;
import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.service.OrderService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@SessionAttributes(value = {"cart"})
public class ShoppingCartController {
    private final OrderService orderService;

    private final GoodService goodService;

    private final UserService userService;

    private final CouponService couponService;

    private final FarmerProductService farmerProductService;

    @Autowired
    public ShoppingCartController(OrderService orderService,
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

    @GetMapping("/Carts")
    public ResponseEntity<Cart> viewCart(@ModelAttribute Cart cart) {
//        List<Goods> goods = goodService.getAllGoods();
//        model.addAttribute("goods", goods);
//        return "order/Cart";
        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }

    @GetMapping("/Carts/Add")
    public ResponseEntity<Cart> cartAdd(@RequestParam Integer itemId,
                          @RequestParam String type,
                          @RequestParam Integer qty,
                          @ModelAttribute Cart cart) {
        CartItem cartItem = null;
        switch (type) {
            case "G":
                cartItem = goodService.getGoods(itemId);
                break;
            case "F":
                cartItem = farmerProductService.findByFarmerProductId(itemId);
                break;
        }

        if (cartItem != null) {
            cart.addItem(cartItem,qty);
        }
//        return "order/CartBody";
        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }

    @GetMapping("/Carts/Remove")
    public ResponseEntity<Cart> cartRemove(@RequestParam String itemNo,
//                             @RequestParam String type,
                             @ModelAttribute Cart cart) {
        CartItem cartItem = null;
        String type = itemNo.substring(0, 1);
        Integer itemId = Integer.valueOf(itemNo.substring(1));
        switch (type) {
            case "G":
                cartItem = goodService.getGoods(itemId);
                break;
            case "F":
                cartItem = farmerProductService.findByFarmerProductId(itemId);
                break;
        }

        if (cartItem != null) {
            cart.removeItem(cartItem.getCartNo());
        }
//        return "order/CartBody";
        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }


    @GetMapping("/Carts/Update")
    public ResponseEntity<Cart> cartUpdate(@RequestParam String itemNo,
//                             @RequestParam String type,
                             @RequestParam Integer qty,
                             @ModelAttribute Cart cart) {
        CartItem cartItem = null;
        String type = itemNo.substring(0, 1);
        Integer itemId = Integer.valueOf(itemNo.substring(1));
        switch (type) {
            case "G":
                cartItem = goodService.getGoods(itemId);
                break;
            case "F":
                cartItem = farmerProductService.findByFarmerProductId(itemId);
                break;
        }

        if (cartItem != null) {
            cart.updataItem(cartItem, qty);
        }
//        return "order/CartBody";
        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }



    @PostMapping(path = "/CheckOut", produces = "text/html;charset=UTF-8")
    public ResponseEntity<String> checkOut(@ModelAttribute Cart cart,
                                           @RequestParam String address,
                                           @RequestParam PayType payType,
                                           HttpServletRequest request,
                                           SessionStatus status,
                                           Authentication authentication) {
        if(authentication==null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        String baseURL = request.getRequestURL().substring(0, request.getRequestURL().length() - request.getRequestURI().length()) + request.getContextPath();
        String orderNo = null;
        if (cart != null) {
            Order order = new Order();

            //設定訂單編號
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            Date current = new Date();
            int end = (int) (Math.random() * 10);
            order.setOrderNo(df.format(current) + end);
            orderNo = order.getOrderNo();
            order.setOrderDate(current);

            //訂單狀態
            order.setOrderStatus(OrderStatus.WAIT_PAYMENT);

            order.setPayType(payType);


//			User user = (User) request.getSession().getAttribute("user");
            User user = userService.getCurrentUser(authentication);


            order.setUser(user);
            order.setAddress(address);
//            order.setOrderType("一般商品");

            order.setShippingFee(cart.getShippingFee());

            order.setOrderItemList(new LinkedHashSet<>(cart.getCart().values()));

            order.getOrderItemList().forEach((e) -> e.setOrder(order));
            if (cart.getCoupon() != null) {
                order.setCoupon(cart.getCoupon());
            }

            order.setTotalPrice(cart.getTotal() - cart.getDiscountAmount());

            order.setDiscountAmount(cart.getDiscountAmount());

            orderService.createOrder(order);

            status.setComplete();

        }
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(baseURL + "/Order/" + orderNo + "/Pay")).build();
    }


    @GetMapping("/Cart/useCoupon")
    public ResponseEntity<Cart> useCoupon(@ModelAttribute Cart cart,
                            @RequestParam String code,
                            Model model) {
        Coupon coupon = couponService.findById(code).orElse(null);
        Date now = new Date();
        if(coupon == null || !"進行中".equals(coupon.getState()) || !(coupon.getMaxQuantity()>coupon.getUsedQuantity())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        cart.setCoupon(coupon);
        //        return "order/CartBody";
        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }


    @ModelAttribute
    public Cart cart(@ModelAttribute Cart cart) {
        if (cart == null) {
            return new Cart();
        }
        return cart;
    }





    @GetMapping("/Carts/getItemList")
    public ResponseEntity<Map<String ,Map<String  ,String >>> getItemList(@ModelAttribute Cart cart) {
        //produectNo,productType+productName
        Map<String ,Map<String  ,String > > res = new HashMap<>();
        Map<String  ,String > map = new HashMap<>();
        List<Goods> allGoods = goodService.getAllGoods();
        List<FarmerProductBean> allFarmerProduc = farmerProductService.findAll();
        for(Goods goods : allGoods){
            if(goods.isEnable()){
                map.put(goods.getCartNo(),goods.getCartName());
            }
        }
        res.put("烘培材料",map);
        map = new HashMap<>();
        for(FarmerProductBean farmerProductBean : allFarmerProduc){
            if(farmerProductBean.isEnable()){
                map.put(farmerProductBean.getCartNo(),farmerProductBean.getCartName());
            }
        }
        res.put("小農",map);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }


}
