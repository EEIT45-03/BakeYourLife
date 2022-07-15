package eeit45.group3.bakeyourlife._init;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import eeit45.group3.bakeyourlife.farmerproduct.service.FarmerProductService;
import eeit45.group3.bakeyourlife.good.service.GoodService;
import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.service.OrderService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.FarmerService;
import eeit45.group3.bakeyourlife.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//@Component
public class DataInitialization implements ApplicationListener<ContextRefreshedEvent> {

    //取消率
    private final Double CANCELLED_RATE = 0.1;
    //退款率
    private final Double REFUND_RATE = 0.1;
    //總訂單數
    private final Integer TOTAL_ORDER_NUMBER = 10000;
    //總用戶數
    private final Integer TOTAL_USER_NUMBER = 222;

    private UserService userService;
    private OrderService orderService;
    private FarmerProductService farmerProductService;
    private GoodService goodService;
    private PasswordEncoder encoder;

    @Autowired
    public DataInitialization(UserService userService, OrderService orderService, FarmerProductService farmerProductService, GoodService goodService, PasswordEncoder encoder) {
        this.userService = userService;
        this.orderService = orderService;
        this.farmerProductService = farmerProductService;
        this.goodService = goodService;
        this.encoder = encoder;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<Order> orders = new ArrayList<>();
        List<User> users = new ArrayList<>();


        System.out.println("Initializing data...");
        System.out.println(farmerProductService.findAll().size());
        System.out.println(goodService.getAllGoods().size());

        //從resources/fakeUserData.json
        InputStream resourceAsStream = getClass().getResourceAsStream("/fakeUserData.json");
        ObjectMapper objectMapper = new ObjectMapper();
        List<FakeUserData> fakeUserData;
        try {
            fakeUserData = objectMapper.readValue(resourceAsStream, new TypeReference<List<FakeUserData>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //現在-365天
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -365);
        Date now = cal.getTime();
        System.out.println(now);

        for(int i = 0;i<365;i++){
            cal.add(Calendar.DATE, 1);
            Date date = cal.getTime();
//            System.out.println(date);
        }






    }

    /**
     * 轉成假資料
     * 帳號密碼為a+手機
     * @param fakeUserData
     * @return
     */
    private User toUser(FakeUserData fakeUserData){
        User user = new User();
        user.setUsername("a"+fakeUserData.getPhone());
        user.setPassword(encoder.encode("a"+fakeUserData.getPhone()));
        user.setFullName(fakeUserData.getName());
        user.setEmail("a"+fakeUserData.getPhone() + "@example.com");
        user.setPhone(fakeUserData.getPhone());
        user.setAuthority("ROLE_USER");
        user.setImageUrl("https://i.imgur.com/gEHJxsi.jpg");
        user.setAddress(fakeUserData.getAddress());
        //隨機0、1
        int random = (int)(Math.random()*2);
        user.setGender(random==0?"男":"女");
        user.setBirth(genRandomDate());
        return user;
    }



    private String genRandomDate(){
        //1957~2007
        int year = (int)(Math.random()*(2007-1957+1))+1957;
        //1~12
        int month = (int)(Math.random()*12)+1;
        //1~25
        int day = (int)(Math.random()*25)+1;
        return year+"-"+month+"-"+day;
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