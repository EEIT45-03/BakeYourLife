package eeit45.group3.bakeyourlife.user.service;

import eeit45.group3.bakeyourlife.user.model.CustomUserDetails;
import eeit45.group3.bakeyourlife.user.model.Farmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import eeit45.group3.bakeyourlife.user.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


	private UserService userService;
	private FarmerService farmerService;

	@Autowired
	public void setUserService(UserService userService ,FarmerService farmerService) {

		this.userService = userService;
		this.farmerService = farmerService;

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails;
		boolean disabled = false;
		boolean accountExpired = false;
		boolean credentialsExpired = false;
		boolean accountLocked = false;
		//使用者是否存在
		User user = userService.findByUsername(username);
		Farmer farmer = farmerService.findByUsername(username);
//		User user1= userService.findByPhone(username);
//		User user2= userService.findByEmail(username);
		if (user == null && farmer == null ) {
			throw new UsernameNotFoundException("使用者名稱:" + username + "不存在");
		} else if (user != null ) {

//			userDetails = new CustomUserDetails(user);
			userDetails = org.springframework.security.core.userdetails.User.builder()
					.username(username)
					.password(user.getPassword())
					.disabled(disabled)
					.accountExpired(accountExpired)
					.credentialsExpired(credentialsExpired)
					.accountLocked(accountLocked)
					.authorities(user.getAuthority())
					//roles會自動加ROLE_
//					.roles("ADMIN")
					.build();

			return userDetails;
		}else {
			userDetails = org.springframework.security.core.userdetails.User.builder()
					.username(username)
					.password(farmer.getPassword())
					.disabled(disabled)
					.accountExpired(accountExpired)
					.credentialsExpired(credentialsExpired)
					.accountLocked(accountLocked)
				.authorities(farmer.getAuthority())
					//roles會自動加ROLE_
//					.roles("USER")
					.build();

			return userDetails;
		}

	}

}