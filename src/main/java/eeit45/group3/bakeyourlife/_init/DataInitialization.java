package eeit45.group3.bakeyourlife._init;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import eeit45.group3.bakeyourlife.coupon.model.Coupon;
import eeit45.group3.bakeyourlife.coupon.service.CouponService;
import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.service.FarmerProductService;
import eeit45.group3.bakeyourlife.good.model.Goods;
import eeit45.group3.bakeyourlife.good.service.GoodService;
import eeit45.group3.bakeyourlife.order.constant.OrderStatus;
import eeit45.group3.bakeyourlife.order.constant.PayType;
import eeit45.group3.bakeyourlife.order.dao.SalesRecordRepository;
import eeit45.group3.bakeyourlife.order.model.Cart;
import eeit45.group3.bakeyourlife.order.model.CartItem;
import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.model.SalesRecord;
import eeit45.group3.bakeyourlife.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


@Component
public class DataInitialization implements ApplicationListener<ContextRefreshedEvent> {

    //取消率
    private final Long CANCELLED_RATE = 5L;
    //退款率
    private final Long REFUND_RATE = 5L;
    //總訂單數
//    private final Integer TOTAL_ORDER_NUMBER = 10000;
    //總用戶數
//    private final Integer TOTAL_USER_NUMBER = 222;

    private Integer couponUsedNumber = 0;

    Coupon coupon;

    List<FarmerProductBean> farmerProducts;

    List<Goods> goods;
    List<CartItem> cartItems;

    Set<String> orderNos = new HashSet<>();

    private CouponService couponService;
    private FarmerProductService farmerProductService;
    private GoodService goodService;
    private SalesRecordRepository salesRecordRepository;
    private PasswordEncoder encoder = new BCryptPasswordEncoder(4);


    @Autowired
    private DataSource dataSource;

    @Autowired
    public DataInitialization(CouponService couponService, FarmerProductService farmerProductService, GoodService goodService,
                              SalesRecordRepository salesRecordRepository) {
        this.couponService = couponService;
        this.farmerProductService = farmerProductService;
        this.goodService = goodService;
        this.salesRecordRepository = salesRecordRepository;
    }


    @Override
//    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<Order> orders = new LinkedList<>();
        List<User> users = new LinkedList<>();
        List<SalesRecord> salesRecords = new LinkedList<>();
        Map<String,CartItem> cartItemsMap = new HashMap<>();
        farmerProducts = farmerProductService.findAll();
        farmerProducts.forEach(o -> {
            cartItemsMap.put(o.getCartNo(),o);
        });
        goods = goodService.getAllGoods();
        goods.forEach(o -> {
            cartItemsMap.put(o.getCartNo(),o);
        });
        cartItems = new ArrayList<>();
        cartItems.addAll(farmerProducts);
        cartItems.addAll(goods);
        coupon = couponService.findById("NEWUSER").orElse(null);

        //從resources/fakeUserData.json
        InputStream resourceAsStream = getClass().getResourceAsStream("/fakeUserData.json");
        ObjectMapper objectMapper = new ObjectMapper();
        List<FakeUserData> fakeUserDatas;
        try {
            fakeUserDatas = objectMapper.readValue(resourceAsStream, new TypeReference<List<FakeUserData>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //現在-365天
        Calendar cal = Calendar.getInstance();
        cal.set(2021, Calendar.JULY, 25, 0, 0, 0);
//        cal.add(Calendar.DATE, -365);
        Date now = cal.getTime();
//        System.out.println(now);

        for (int i = 0; i < 365; i++) {
            cal.add(Calendar.DATE, 1);
            Date date = cal.getTime();
//            System.out.println(date);
            //每天產生3個會員
            int size = fakeUserDatas.size();

            for (int j = 0; j < 3; j++) {
                //隨機產生會員資料
                FakeUserData fakeUserData = fakeUserDatas.get(new Random().nextInt(fakeUserDatas.size()));
                fakeUserDatas.remove(fakeUserData);
                User user = toUser(fakeUserData);
                //隨機28800000(8H)~82800000(23H)
                user.setRegisterTime(new Timestamp(date.getTime() + (long) (Math.random() * (82800000 - 28800000))));
                users.add(user);
            }


            //打散User資料
            List<User> shuffle = new ArrayList<>(users);
            Collections.shuffle(shuffle);
            //產生訂單
            int finalI = i;
            shuffle.forEach(user -> {
                //30%機率產生訂單
                double range = 0.2;
                if(finalI > 300){
                    range = 0.2 + (finalI*0.001);
                }
                if (Math.random() < range) {
                    long registerTime = user.getRegisterTime().getTime();
                    //產生registerTime後的訂單，今天前的隨機時間
                    long end = date.getTime() + 86400000;
                    //隨機registerTime~end隨機數字
                    long orderDate = registerTime + (long) (Math.random() * (end + 5 - registerTime));
                    Order order;
                    if(range > 0.3){
                        order = genOrder(user, new Date(orderDate),true);
                    }else {
                        order = genOrder(user, new Date(orderDate),false);
                    }
                    orders.add(order);

                    order.getOrderItemList().forEach(e -> {
                        if(e.getProductNo().charAt(0) == 'G'){
                            Goods goods = (Goods) cartItemsMap.get(e.getProductNo());
                            //銷售紀錄
                            SalesRecord salesRecord = new SalesRecord();
                            salesRecord.setProductNo(goods.getCartNo());
                            salesRecord.setProductId(goods.getId());
                            salesRecord.setSalesQty(e.getQty());
                            salesRecord.setSalesDate(order.getOrderDate());
                            salesRecord.setSalesSubTotal(e.getSubTotal());
                            salesRecords.add(salesRecord);
                        }
                        if(e.getProductNo().charAt(0) == 'F'){
                            FarmerProductBean farmerProduct = (FarmerProductBean) cartItemsMap.get(e.getProductNo());
                            //銷售紀錄
                            SalesRecord salesRecord = new SalesRecord();
                            salesRecord.setFarmerId(farmerProduct.getFarmer().getFarmerId());
                            salesRecord.setProductNo(farmerProduct.getCartNo());
                            salesRecord.setProductId(farmerProduct.getFarmerProductId());
                            salesRecord.setSalesQty(e.getQty());
                            salesRecord.setSalesDate(order.getOrderDate());
                            salesRecord.setSalesSubTotal(e.getSubTotal());
                            salesRecords.add(salesRecord);
                        }
                    });
                }
            });


        }


        long start = System.currentTimeMillis();

        InsertInitDataJdbc jdbc = new InsertInitDataJdbc(dataSource);

        jdbc.saveAllByUsers(users);
        jdbc.saveAllByOrders(orders);
//        jdbc.saveAllBySalesRecords(salesRecords);
        coupon.setUsedQuantity(couponUsedNumber);
        couponService.updateCoupon(coupon);
        long end = System.currentTimeMillis();

        System.out.println(String.format("Total time: %d 毫秒", (end - start)));
        System.out.println("DataInitialization finished");

    }



    /**
     * 轉成假資料
     * 帳號密碼為a+手機
     *
     * @param fakeUserData
     * @return
     */
    private User toUser(FakeUserData fakeUserData) {
        User user = new User();
        char firstChar = (char) (new Random().nextInt(26) + 97);
        String username = firstChar + fakeUserData.getPhone();
        user.setUsername(username);
        user.setPassword(encoder.encode(username));
        user.setEnabled(true);
        user.setFullName(fakeUserData.getName());
        //a-z ascii 97~122
        user.setEmail(username + "@example.com");
        user.setPhone(fakeUserData.getPhone());
        user.setAuthority("ROLE_USER");
        user.setImageUrl("https://i.imgur.com/gEHJxsi.jpg");
        user.setAddress(fakeUserData.getAddress());
        //隨機0、1
        int random = (int) (Math.random() * 2);
        user.setGender(random == 0 ? "男" : "女");
        user.setBirth(genRandomDate());
        return user;
    }

    private Order genOrder(User user, Date date, boolean high) {
//        //隨機1~100
        long random = (int) (Math.random() * 100);
        Order order = null;
        if(high){
            order = genCart(true).getOrder();
        }else {
            order = genCart(false).getOrder();
        }
        order.setUser(user);
        order.setOrderDate(date);
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        int end;
        do {
            end = (int) (Math.random() * 10);
            order.setOrderNo(df.format(date) + end);
        } while (orderNos.contains(order.getOrderNo()));
//		order.setOrderNo(df.format(date) + end);
        orderNos.add(order.getOrderNo());
        if (random < CANCELLED_RATE) {
            order.setOrderStatus(OrderStatus.CANCELLED);
            order.setAddress(user.getAddress());
            order.setReview(false);
            order.setPayType(Math.random() < 0.5 ? PayType.ECPAY : PayType.PAYPAL);
        } else if (random > CANCELLED_RATE && random < CANCELLED_RATE + REFUND_RATE) {
            order.setOrderStatus(OrderStatus.REFUNDED);
            order.setAddress(user.getAddress());
            order.setReview(false);
            order.setPayType(Math.random() < 0.5 ? PayType.ECPAY : PayType.PAYPAL);
            random = (long) (Math.random() * (86400000 - 300000)) + 300000;
            order.setPayDate(new Timestamp(date.getTime() + random));
            //0~2
            random = (int) (Math.random() * 3);
            switch ((int) random) {
                case 0:
                    order.setRefundReason("等太久");
                    break;
                case 1:
                    order.setRefundReason("我不想買了");
                    break;
                case 2:
                    order.setRefundReason("買錯東西");
                    break;
            }
        } else {
            order.setOrderStatus(OrderStatus.FINISH);
            order.setAddress(user.getAddress());
            order.setReview(false);
            order.setPayType(Math.random() < 0.5 ? PayType.ECPAY : PayType.PAYPAL);
            //隨機300000~86400000(1D)數字
            random = (long) (Math.random() * (86400000 - 300000)) + 300000;
            order.setPayDate(new Timestamp(date.getTime() + random));
            random = (long) (Math.random() * (86400000 * 7 - 43200000)) + random;
            order.setShipDate(new Timestamp(date.getTime() + random));
        }
        return order;
    }


    private Cart genCart(boolean high) {
        //隨機1~5
        Random generator = new Random(new Date().getTime());
        int buyNum = generator.nextInt(5) + 1;
//        int buyNum = (int) (Math.random() * 5) + 1;
        int productNum = cartItems.size();
        Cart cart = new Cart();
        //建立隨機商品及數量
        for (int i = 0; i < buyNum; i++) {
            //隨機1~productNum
            int random = (int) (Math.random() * productNum);
            CartItem cartItem = cartItems.get(random);
            int qty = 1;
//            if (cartItem.getCartPrice() < 500) {
//                qty = (int) (Math.random() * 10);
//            }
            if(high){
                qty = (int) (Math.random() * 3);
            }
            cart.addItem(cartItem, qty);
        }
        //是否使用優惠券0、1
        int random = (int) (Math.random() * 2);
        if (random == 1) {
            cart.setCoupon(coupon);
            couponUsedNumber++;
        }

        return cart;
    }


    private String genRandomDate() {
        //1957~2007
        int year = (int) (Math.random() * (2007 - 1957 + 1)) + 1957;
        //1~12
        int month = (int) (Math.random() * 12) + 1;
        //1~25
        int day = (int) (Math.random() * 25) + 1;
        return year + "-" + month + "-" + day;
    }
}

class FakeUserData {
    private String name;
    private String phone;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}