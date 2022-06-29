package eeit45.group3.bakeyourlife.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import eeit45.group3.bakeyourlife.user.model.CustomUserDetails;
import eeit45.group3.bakeyourlife.user.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    boolean disabled = false;
	    boolean accountExpired = false;
	    boolean credentialsExpired = false;
	    boolean accountLocked = false;
		User user = userService.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("使用者名稱:" + username + "不存在");
		}

//		UserDetails userDetails = new CustomUserDetails(user);
		UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
				.username(user.getUserName())
				.password(user.getPassword())
				.disabled(disabled)
				.accountExpired(accountExpired)
				.credentialsExpired(credentialsExpired)
				.accountLocked(accountLocked)
//				.authorities("ROLE_ADMIN")
				//roles會自動加ROLE_
				.roles("ADMIN")
				.build();

		return userDetails;
	}

}
