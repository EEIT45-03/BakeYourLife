package eeit45.group3.bakeyourlife._init;

import eeit45.group3.bakeyourlife.rental.model.Venue;
import eeit45.group3.bakeyourlife.rental.service.RentalService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class AdminDataInitialization implements ApplicationListener<ContextRefreshedEvent> {


    UserService userService;

    RentalService rentalService;

    @Autowired
    public AdminDataInitialization(UserService userService,RentalService rentalService) {
        this.userService = userService;
        this.rentalService = rentalService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        User user = userService.findByUsername("user");
        //建立管理員帳戶
        if (user == null) {
            user = new User("user", "user", "管理者", "vison919@gmail.com"
                    , "0918583187", "1994-09-19", "男", "桃園市楊梅區中山路121巷4弄9號");
            userService.save(user);
        } else if ("user".equals(user.getPassword())) {
            //加密密碼
            user.setPassword("user");
            userService.updateUser(user);
        }

        Venue venue = rentalService.findByVenueId(1);
        if (venue == null){
            venue= new Venue("B201", 10);
            rentalService.createVenue(venue);
        }
    }

}
