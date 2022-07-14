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
	  String farmerName;
	  String fullName;

	public CustomUserDetails(User user) {
		this.user = user;
	}

	public CustomUserDetails(Farmer farmer) {
		this.farmer = farmer;
	}

	public CustomUserDetails() {
	}

	public CustomUserDetails(User user, Farmer farmer, String farmerName, String fullName) {
		this.user = user;
		this.farmer = farmer;
		this.farmerName = farmerName;
		this.fullName = fullName;
	}
	@Override
	public String getPassword() {
		return this.user.getPassword();
	}
	
	@Override
	public String getUsername() {
		return this.user.getUsername();
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
		return AuthorityUtils.createAuthorityList(user.getAuthority());
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

	public String getFarmerName() {
		return this.farmer.getFarmerName();
	}

	public String getFullName() {
		return this.user.getFullName();
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
}

