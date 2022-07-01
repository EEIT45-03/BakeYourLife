package eeit45.group3.bakeyourlife.user.dao;

import eeit45.group3.bakeyourlife.user.model.User;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    User findByPhone(String phone);
    User findByEmail(String email);
}
