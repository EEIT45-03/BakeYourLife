package eeit45.group3.bakeyourlife.user.dao;

import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.utils.UserQueryChart;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
  User findByUsername(String username);

  User findByPhone(String phone);

  User findByEmail(String email);

  @Query("SELECT u FROM User u WHERE u.verificationCode = ?1")
  public User findByVerificationCode(String code);

  @Query(
      nativeQuery = true,
      value = "select gender AS 'label', count(gender) AS 'Value' from users GROUP BY gender")
  List<UserQueryChart> findUserGenderAmount();

  @Query(nativeQuery = true, value = "select count(enabled)AS 'value' from users where enabled=0")
  Long countEnabled();

  @Query(
      nativeQuery = true,
      value =
          "SELECT CONVERT(char(7), u.register_time, 111) AS 'label', count(u.register_time) AS 'value' FROM users u  GROUP BY CONVERT(char(7), u.register_time, 111) ORDER BY CONVERT(char(7), u.register_time, 111)")
  List<UserQueryChart> findUserMonthSignupAmount();
}
