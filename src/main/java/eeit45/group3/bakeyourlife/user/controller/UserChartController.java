package eeit45.group3.bakeyourlife.user.controller;

import eeit45.group3.bakeyourlife.user.dao.UserRepository;
import eeit45.group3.bakeyourlife.user.utils.UserChart;
import eeit45.group3.bakeyourlife.user.utils.UserQueryChart;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserChartController {

  private final UserRepository userRepository;

  @Autowired
  public UserChartController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/admin/user/UserGenderCount")
  public UserChart findUserGenderAmount() {
    UserChart userChart = new UserChart();
    List<UserQueryChart> userCountList = userRepository.findUserGenderAmount();
    for (UserQueryChart data : userCountList) {
      userChart.addData(data);
    }
    return userChart;
  }

  @GetMapping("/admin/user/UsermonthSignUPAmount")
  public UserChart findMonthSignupAmount() {
    UserChart userChart = new UserChart();
    List<UserQueryChart> userCountList = userRepository.findUserMonthSignupAmount();
    for (UserQueryChart data : userCountList) {
      userChart.addData(data);
    }
    return userChart;
  }
}
