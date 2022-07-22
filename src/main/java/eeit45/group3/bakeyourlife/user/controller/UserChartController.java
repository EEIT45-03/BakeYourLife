package eeit45.group3.bakeyourlife.user.controller;


import eeit45.group3.bakeyourlife.user.dao.UserRepository;
import eeit45.group3.bakeyourlife.user.utils.UserChart;
import eeit45.group3.bakeyourlife.user.utils.UserQueryChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserChartController {

    private final UserRepository userRepository;


    @Autowired
    public UserChartController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/UserGenderCount")
    public UserChart findUserGenderAmount() {
        UserChart userChart = new UserChart();
        List<UserQueryChart> userCountList = userRepository.findUserGenderAmount();
        for (UserQueryChart data : userCountList) {
            userChart.addData(data);
        }
        return userChart;
    }
}
