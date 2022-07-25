package eeit45.group3.bakeyourlife.user.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

public class CustomOAuth2User implements OAuth2User {
    private OAuth2User oauth2User;
    private User user;


    public CustomOAuth2User(OAuth2User oauth2User) {
        this.oauth2User = oauth2User;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oauth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return oauth2User.getAuthorities();
    }

    @Override
    public String getName() {
        return oauth2User.getAttribute("name");
    }
    public String getFullName() {
        return oauth2User.getAttribute("name");
    }
    public String getEmail() {
        return oauth2User.getAttribute("email");
    }
    public String getImageUrl() {
        return oauth2User.getAttribute("picture");
    }


    @Override
    public String toString() {
        return "CustomOAuth2User{" +
                "oauth2User=" + oauth2User +
                '}';
    }
}
