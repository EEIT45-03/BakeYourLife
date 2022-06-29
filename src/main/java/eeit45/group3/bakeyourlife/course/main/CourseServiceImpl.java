package eeit45.group3.bakeyourlife.course.main;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CourseServiceImpl implements CourseService {
	@Autowired
	SessionFactory factory;
	@Autowired
	CourseDao courseDao;

	public CourseServiceImpl() {
//		courseDao = new CourseDaoImpl();
//		factory = HibernateUtils.getSessionFactory();
	}
/*
	@Override
	public List<Course> findAllByOrderDateBetween(Date orderDateStart, Date orderDateEnd) {
		// TODO Auto-generated method stub
		return orderDao.findAllByOrderDateBetween(orderDateStart, orderDateEnd);
	}
*/
	@Override
	public List<Course> findAll() {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		List<Course> list = courseDao.findAll();
//		try {
//			tx = session.beginTransaction();
			list = courseDao.findAll();
//		    tx.commit();
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
		return list;
	}

	@Override
	public Optional<Course> findCourseById(Integer openCourse) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		Optional<Course> course = null;
//		try {
//			tx = session.beginTransaction();
			course = courseDao.findById(openCourse);
//		    tx.commit();
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
		return course;
	}

	/*@Override
	public Optional<Order> findByOrderNo(String orderNo) {
		// TODO Auto-generated method stub
		return orderDao.findByOrderNo(orderNo);
	}*/

	@Override
	@Transactional
	public void deleteCourse(Integer openCourse) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			courseDao.deleteById(openCourse);
//		    tx.commit();
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
	}

	@Override
	@Transactional
	public void updateCourse(Course course) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			courseDao.updateCourse(course);
//		    tx.commit();
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
}

	@Override
	@Transactional
	public void createCourse(Course course) {
		
		courseDao.createCourse(course);

	}
	
}

/*	@Override
	public void addOrderItem(OrderItem orderItem) {
		orderDao.addOrderItem(orderItem);
	}*/

	/*	@Override
	public void deleteCourse(String OpenCourse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCourse(Course Course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int createCourse(Course Course) {
		// TODO Auto-generated method stub
		return 0;
	}

}*/
