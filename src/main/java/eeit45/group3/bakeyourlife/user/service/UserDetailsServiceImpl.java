package eeit45.group3.bakeyourlife.user.service;

import eeit45.group3.bakeyourlife.user.model.CustomUserDetails;
import eeit45.group3.bakeyourlife.user.model.Farmer;
import eeit45.group3.bakeyourlife.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private UserService userService;
  private FarmerService farmerService;

  @Autowired
  public void setUserService(UserService userService, FarmerService farmerService) {

    this.userService = userService;
    this.farmerService = farmerService;
  }

  @Override
  public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    CustomUserDetails userDetails;
    // 使用者是否存在
    User user = userService.findByUsername(username);
    Farmer farmer = farmerService.findByUsername(username);
    if (user == null && farmer == null) {
      throw new UsernameNotFoundException("使用者名稱:" + username + "不存在");
    } else if (user != null) {
      userDetails = new CustomUserDetails(user);
      return userDetails;
    } else {
      userDetails = new CustomUserDetails(farmer);
      return userDetails;
    }
  }
}
