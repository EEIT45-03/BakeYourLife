package eeit45.group3.bakeyourlife.user.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import eeit45.group3.bakeyourlife.user.model.User;


public interface UserService {

    User save(User user);
    User getCurrentUser(Authentication authentication);


    void setCurrentUser(Authentication authentication, User user);

    List<User> findAll();

    User findByUserId(Integer userId);

    User findByUsername(String username);

    void deleteByUserId(Integer userId);

    void updateUser(User user);


    User findByPhone(String phone);

    User findByEmail(String email);
}
