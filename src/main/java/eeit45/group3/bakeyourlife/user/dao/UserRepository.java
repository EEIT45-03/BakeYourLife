package eeit45.group3.bakeyourlife.user.dao;

import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.utils.UserQueryChart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findByPhone(String phone);

    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.verificationCode = ?1")
    public User findByVerificationCode(String code);

    @Query(nativeQuery = true, value ="select gender AS 'label', count(gender) AS 'Value' from users GROUP BY gender")
    List<UserQueryChart> findUserGenderAmount();


}
