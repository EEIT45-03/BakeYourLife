package eeit45.group3.bakeyourlife.user.service;

import java.util.List;

import eeit45.group3.bakeyourlife.user.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eeit45.group3.bakeyourlife.user.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    UserRepository repository;

    PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public User save(User user) {
        // 加密密碼
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findByUserId(Integer userId) {
        return repository.findById(userId).orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void deleteByUserId(Integer userId) {
        repository.deleteById(userId);

    }

    @Override
    public void updateUser(User user) {
        // 加密密碼
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);

    }

    @Override
    public User findByPhone(String phone) {
        return repository.findByPhone(phone);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

}
