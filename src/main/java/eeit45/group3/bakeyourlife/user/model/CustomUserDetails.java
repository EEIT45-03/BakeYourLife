package eeit45.group3.bakeyourlife.user.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;

	public CustomUserDetails(User user) {
		this.user = user;
	}

	public CustomUserDetails() {
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}
	
	@Override
	public String getUsername() {
		return this.user.getUserName();
	}
	
	@Override
	public boolean isAccountNonExpired() {
//		return this.user.isAccountNonExpired();
		return true;
	}
	




	@Override
	public boolean isAccountNonLocked() {
//		return this.user.isAccountNonLocked();
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
//		return this.user.isCredentialsNonExpired();
		return true;
	}

	@Override
	public boolean isEnabled() {
//		return this.user.isEnabled();
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return AuthorityUtils.createAuthorityList(user.getRole());
		return AuthorityUtils.createAuthorityList("ADMIN");
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	}

