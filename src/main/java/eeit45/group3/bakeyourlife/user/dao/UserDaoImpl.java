package eeit45.group3.bakeyourlife.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eeit45.group3.bakeyourlife.user.model.User;

//@Repository
public class UserDaoImpl implements UserDao {
	SessionFactory factory;

	@Autowired
	public UserDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public Object save(User user) {
		Session session = factory.getCurrentSession();
		return session.save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		Session session = factory.getCurrentSession();
		String hql_findAll = "FROM User";
		List<User> users = new ArrayList<>();
		users = session.createQuery(hql_findAll).getResultList();
		return users;
	}

	@Override
	public User findByUserId(Integer userId) {
		Session session = factory.getCurrentSession();
		User user = session.get(User.class, userId);
		return user;
	}

	@Override
	public User findByUserName(String userName) {
		Session session = factory.getCurrentSession();
		String hql_userIsExist = "FROM User u WHERE u.userName = :uname";
		User user = session.createQuery(hql_userIsExist, User.class).setParameter("uname", userName).uniqueResult();
		return user;
	}

	@Override
	public void deleteByUserId(Integer userId) {
		Session session = factory.getCurrentSession();
		User user = new User();
		user.setUserId(userId);
		session.delete(user);
	}

	@Override
	public void updateUser(User user) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(user);
	}

}
