package eeit45.group3.bakeyourlife.user.dao;

import java.util.List;

import eeit45.group3.bakeyourlife.user.model.User;

public interface UserDao {

	Object save(User user);

	List<User> findAll();

	User findByUserId(Integer userId);

	User findByUsername(String username);

	void deleteByUserId(Integer userId);

	void updateUser(User user);

}