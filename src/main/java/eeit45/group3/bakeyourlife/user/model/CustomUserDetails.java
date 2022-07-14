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
	private Farmer farmer;


	public CustomUserDetails(User user) {
		this.user = user;
	}

	public CustomUserDetails(Farmer farmer) {
		this.farmer = farmer;
	}

	public CustomUserDetails() {
	}

	@Override
	public String getPassword() {
		String password = null;
		if (this.user != null) {
			password = this.user.getPassword();
		} else if (this.farmer != null) {
			password = this.farmer.getPassword();
		}
		return password;
	}
	
	@Override
	public String getUsername() {

		String username = null;
		if (this.user != null) {
			username = this.user.getUsername();
		} else if (this.farmer != null) {
			username = this.farmer.getUsername();
		}
		return username;
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

		String authority = null;
		if (this.user != null) {
			authority = this.user.getAuthority();
		} else if (this.farmer != null) {
			authority = this.farmer.getAuthority();
		}
		return AuthorityUtils.createAuthorityList(authority);
//		return AuthorityUtils.createAuthorityList(user.getAuthority());
//		return AuthorityUtils.createAuthorityList("ROLE_ADMIN");
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	public String getImageUrl() {
		String imageUrl = null;
		if (this.user != null) {
			imageUrl = this.user.getImageUrl();
		} else if (this.farmer != null) {
			imageUrl = this.farmer.getImageUrl();
		}
		return imageUrl;
	}
	public String getFullName() {
		String fullname = null;
		if (this.user != null) {
			fullname = this.user.getFullName();
		} else if (this.farmer != null) {
			fullname = this.farmer.getFarmerName();
		}
		return fullname;
	}
	public Integer getId() {
		Integer id = null;
		if (this.user != null) {
			id = this.user.getUserId();
		} else if (this.farmer != null) {
			id = this.farmer.getFarmerId();
		}
		return id;
	}
}

