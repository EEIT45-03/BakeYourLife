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
import eeit45.group3.bakeyourlife.order.model.SalesRecord;
import eeit45.group3.bakeyourlife.order.service.OrderService;
import eeit45.group3.bakeyourlife.order.service.SalesRecordService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

    private final SalesRecordService salesRecordService;
    @Autowired
    private RedisTemplate<String, Cart> redisTemplate;
    @Autowired
    public ShoppingCartController(OrderService orderService, GoodService goodService, UserService userService, CouponService couponService, FarmerProductService farmerProductService, SalesRecordService salesRecordService) {
        this.orderService = orderService;
        this.goodService = goodService;
        this.userService = userService;
        this.couponService = couponService;
        this.farmerProductService = farmerProductService;
        this.salesRecordService = salesRecordService;
    }


    //可以使用ModelMap把需要物件放在Session中
    @GetMapping("/Carts")
    public ResponseEntity<Cart> viewCart(@ModelAttribute Cart cart, Authentication authentication, ModelMap model) {
        if(authentication!=null){
            User user = userService.getCurrentUser(authentication);
            if(user!= null && redisTemplate.opsForValue().get("cart_" + user.getUserId()) != null){
            cart = redisTemplate.opsForValue().get("cart_" + user.getUserId());
            model.addAttribute("cart", cart);
            }

        }
        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }

    @GetMapping("/Carts/Add")
    public ResponseEntity<Cart> cartAdd(@RequestParam Integer itemId,
                          @RequestParam String type,
                          @RequestParam Integer qty,
                          @ModelAttribute Cart cart,
                          Authentication authentication) {
        User currentUser = null;
        if(authentication!=null){
            currentUser = userService.getCurrentUser(authentication);
        }
        CartItem cartItem = getCartItem(type,itemId);

        return getCartResponseEntity(qty, cart, cartItem, currentUser);
    }

    @GetMapping("/Carts/Remove")
    public ResponseEntity<Cart> cartRemove(@RequestParam String itemNo,
                             @ModelAttribute Cart cart,
                             Authentication authentication) {
        User currentUser = null;
        if(authentication!=null){
            currentUser = userService.getCurrentUser(authentication);
        }
        String type = itemNo.substring(0, 1);
        Integer itemId = Integer.valueOf(itemNo.substring(1));
        CartItem cartItem = getCartItem(type,itemId);

        if (cartItem != null) {
            cart.removeItem(cartItem.getCartNo());
        }
        if(currentUser!= null){
        redisTemplate.opsForValue().set("cart_" + currentUser.getUserId(), cart);
        }
        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }


    @GetMapping("/Carts/Update")
    public ResponseEntity<Cart> cartUpdate(@RequestParam String itemNo,
//                             @RequestParam String type,
                             @RequestParam Integer qty,
                             @ModelAttribute Cart cart,
                              Authentication authentication) {
        User currentUser = null;
        if(authentication!=null){
        currentUser = userService.getCurrentUser(authentication);
        }
        String type = itemNo.substring(0, 1);
        Integer itemId = Integer.valueOf(itemNo.substring(1));
        CartItem cartItem = getCartItem(type,itemId);


        return getCartResponseEntity(qty, cart, cartItem,currentUser);
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

            order.getOrderItemList().forEach((e) -> {
                if(e.getProductNo().charAt(0) == 'G'){
                    Goods goods = goodService.getGoods(Integer.parseInt(e.getProductNo().substring(1)));
                    goods.updateStock(goods.getStock() - e.getQty());
                    goodService.updateGoods(goods);
                    //銷售紀錄
                    SalesRecord salesRecord = new SalesRecord();
                    salesRecord.setProductNo(goods.getCartNo());
                    salesRecord.setProductId(goods.getId());
                    salesRecord.setSalesQty(e.getQty());
                    salesRecord.setSalesDate(order.getOrderDate());
                    salesRecord.setSalesSubTotal(e.getSubTotal());
                    salesRecordService.createSalesRecord(salesRecord);
                }
                if(e.getProductNo().charAt(0) == 'F'){
                    FarmerProductBean farmerProduct = farmerProductService.findByFarmerProductId(Integer.parseInt(e.getProductNo().substring(1)));
                    farmerProduct.updateStock(farmerProduct.getStock() - e.getQty());
                    //銷售紀錄
                    SalesRecord salesRecord = new SalesRecord();
                    salesRecord.setFarmerId(farmerProduct.getFarmer().getFarmerId());
                    salesRecord.setProductNo(farmerProduct.getCartNo());
                    salesRecord.setProductId(farmerProduct.getFarmerProductId());
                    salesRecord.setSalesQty(e.getQty());
                    salesRecord.setSalesDate(order.getOrderDate());
                    salesRecord.setSalesSubTotal(e.getSubTotal());
                    salesRecordService.createSalesRecord(salesRecord);
                    farmerProductService.update(farmerProduct);
                }
                e.setOrder(order);
            });
            if (cart.getCoupon() != null) {
                order.setCoupon(cart.getCoupon());
            }

            order.setTotalPrice(cart.getTotal() - cart.getDiscountAmount());

            order.setDiscountAmount(cart.getDiscountAmount());

            orderService.createOrder(order);

            status.setComplete();
            redisTemplate.opsForValue().set("cart_" + user.getUserId(), new Cart());
        }
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(baseURL + "/Order/" + orderNo + "/Pay")).build();
    }


    @GetMapping("/Cart/useCoupon")
    public ResponseEntity<Cart> useCoupon(@ModelAttribute Cart cart,
                            @RequestParam String code,
                            Authentication authentication) {
        Coupon coupon = couponService.findById(code).orElse(null);
        Date now = new Date();
        if(coupon == null || !"進行中".equals(coupon.getState()) || !(coupon.getMaxQuantity()>coupon.getUsedQuantity())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        User currentUser = userService.getCurrentUser(authentication);
        if(orderService.findByByCoupon(currentUser, coupon) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        cart.setCoupon(coupon);
        redisTemplate.opsForValue().set("cart_" + currentUser.getUserId(), cart);
        //        return "order/CartBody";
        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }


    /*
    只會需要時建一次(無登入時會自動建立[因為購物車AJAX]，登入時不會再呼叫此方法)
     */
    @ModelAttribute("cart")
    public Cart cart(@ModelAttribute Cart cart, Authentication authentication) {
        User user = null;
        Cart cartRedis = null;
        if(authentication!=null){
            user = userService.getCurrentUser(authentication);
            cartRedis = redisTemplate.opsForValue().get("cart_" + user.getUserId());
            cart = cartRedis;
        }
        if (cart == null) {
            cart = new Cart();
            if(user!=null){
                redisTemplate.opsForValue().set("cart_" + user.getUserId(), cart);
            }
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


    private ResponseEntity<Cart> getCartResponseEntity(@RequestParam Integer qty, Cart cart, CartItem cartItem, User currentUser) {
        Cart cartRedis = null;
        if(currentUser!=null){
            cartRedis = redisTemplate.opsForValue().get("cart_" + currentUser.getUserId());
            if(cartRedis!=null){
                cart = cartRedis;
            }
        }
        if (cartItem != null && cartItem.isEnable() && cartItem.getStock()>=qty) {
            cart.updataItem(cartItem,qty);
        }else if(!cartItem.isEnable()) {
            Cart error = new Cart();
            error.setMessage("商品不存在或已下架");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }else if(cartItem.getStock()<qty) {
            Cart error = new Cart();
            error.setMessage("庫存不足");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
        if(currentUser!=null){
            redisTemplate.opsForValue().set("cart_" + currentUser.getUserId(), cart);
        }
        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }



    private CartItem getCartItem(String type, Integer itemId) {
        switch (type) {
            case "G":
                return goodService.getGoods(itemId);
            case "F":
                return farmerProductService.findByFarmerProductId(itemId);
        }
        return null;
    }


}
