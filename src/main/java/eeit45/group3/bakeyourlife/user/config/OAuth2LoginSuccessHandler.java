package eeit45.group3.bakeyourlife.user.config;

import eeit45.group3.bakeyourlife.user.model.CustomOAuth2User;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  @Autowired private UserService userService;

  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException, ServletException {

    CustomOAuth2User customOAuth2User = (CustomOAuth2User) authentication.getPrincipal();
    String email = customOAuth2User.getEmail();
    String name = customOAuth2User.getName();
    String imageUrl = customOAuth2User.getImageUrl();

    User user = userService.findByEmail(email);
    if (user == null) {

      userService.createNewUserAfterOAuthLoginSuccess(email, name, imageUrl);

    } else {

      userService.updateUserAfterOAuthLoginSuccess(user, name);
    }

    System.out.println("google登入E-mail: " + email);
    System.out.println(customOAuth2User);

    super.onAuthenticationSuccess(request, response, authentication);
  }
}
