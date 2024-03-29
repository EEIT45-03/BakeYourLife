package eeit45.group3.bakeyourlife.config;

import eeit45.group3.bakeyourlife.user.config.OAuth2LoginSuccessHandler;
import eeit45.group3.bakeyourlife.user.service.CustomOauth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

  UserDetailsService userDetailsService;

  CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

  OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;

  private CustomOauth2UserService customOauth2UserService;

  @Autowired
  @Lazy
  public void setUserDetailsService(
      UserDetailsService userDetailsService,
      CustomAuthenticationFailureHandler customAuthenticationFailureHandler,
      OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler,
      CustomOauth2UserService customOauth2UserService) {
    this.userDetailsService = userDetailsService;
    this.customAuthenticationFailureHandler = customAuthenticationFailureHandler;
    this.oAuth2LoginSuccessHandler = oAuth2LoginSuccessHandler;
    this.customOauth2UserService = customOauth2UserService;
  }

  @Bean
  public PasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests()
        // login頁面不需要認證
        .antMatchers(
            "/*",
            "/ArticlesType/**",
            "/FrontArticle/*",
            "/Rental/**",
            "/Venues/**",
            "/VenueSelect/**",
            "/Goods1/**",
            "/FarmerProductShop/**",
            "/FarmerProducts/**",
            "/Carts/**",
            "/Course/**",
            "/webfonts/**",
            "/SignUp",
            "/login",
            "/Order/*/Result",
            "/Order/PaySuccess",
            "/css/**",
            "/js/**",
            "/img/**")
        .permitAll()
        .antMatchers("/admin/**")
        .hasRole("ADMIN")
        .antMatchers("/User/**")
        .hasAnyRole("USER", "ADMIN")
        .antMatchers("/FarmerProductSupplier/**")
        .hasAnyRole("FARMER", "ADMIN")
        // 其他都要認證
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        // 自訂登入頁
        .loginPage("/login")
        // 1.successForwardUrl：請求轉發，轉發後瀏覽器的位址不會變，登入成功後不會跳轉到原來的位址。
        // 2.defaultSuccessUrl：302重定向，登入成功後會跳轉到原來的位址。
        .failureHandler(customAuthenticationFailureHandler)
        .defaultSuccessUrl("/default", false)
        .and()
        .rememberMe()
        .key("123")
        .tokenValiditySeconds(60 * 60 * 24)
        .userDetailsService(userDetailsService)
        //                .alwaysRemember(true)
        //                .useSecureCookie(true)
        .and()
        .httpBasic()
        .and()
        // 使用自己實作的userDetailsService
        .userDetailsService(userDetailsService)
        // 綠界需要關csrf
        .csrf()
        .disable()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
        .and()
        .oauth2Login()
        .loginPage("/login")
        .userInfoEndpoint()
        .userService(customOauth2UserService)
        .and()
        .successHandler(oAuth2LoginSuccessHandler);
    return http.build();
  }
}
