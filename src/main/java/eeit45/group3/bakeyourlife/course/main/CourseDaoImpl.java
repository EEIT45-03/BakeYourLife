package eeit45.group3.bakeyourlife.course.main;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;


@Repository("courseDao")
@Transactional(propagation = Propagation.MANDATORY)
public class CourseDaoImpl implements CourseDao {
	
	@Autowired
	SessionFactory factory;

//	public CourseDaoImpl() {
//		factory = HibernateUtils.getSessionFactory();
//	}
	
	@Override
	public List<Course> findAll() {
		String hql = "FROM Course";
		Session session = factory.getCurrentSession();
		List<Course> courses = session.createQuery(hql, Course.class)
				.getResultList();
		return courses;
	}

	@Override
	public Optional<Course> findById(Integer openCourse) {
		Session session = factory.getCurrentSession();
		Course course = session.get(Course.class, openCourse);
		return Optional.ofNullable(course);
	}

	@Override
	public void deleteById(Integer openCourse) {
		Session session = factory.getCurrentSession();
		Course course = findById(openCourse).orElse(null);
		session.delete(course);	
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(course);
		
	}

	@Override
	public void createCourse(Course course) {
		Session session = factory.getCurrentSession();
		session.save(course);
//		return eeit45.group3.bakeyourlife.course.getOpenCourse();
	}
}
	
	/*

	@Override
	public List<Test> findAll() {
		List<Test> list = new ArrayList<Test>();
		try {
			conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Test test = new Test();
				test.setId(rs.getInt("id"));
				test.setName(rs.getString("name").trim());
				list.add(test);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public Test findById(Integer id) {
		Test test = new Test();
		try {
			conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_FIND_BY_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				test.setId(rs.getInt("id"));
				test.setName(rs.getString("name").trim());
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return test;
	}

	@Override
	public void deleteById(Integer id) {
		try {
			conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_DELETE);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	*/
	
	
	/*
	@Override
	public void save(Course eeit45.group3.bakeyourlife.course) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course findById(String OpenCourse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String OpenCourse) {
		// TODO Auto-generated method stub
		
	}
	*/
	
	/*
	@Override
	public Course findById(String OpenCourse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String OpenCourse) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void save(Course eeit45.group3.bakeyourlife.course) {
		
		
		try {
			// Allocate and use a connection from the pool
			conn = ds.getConnection();
			
			PreparedStatement ps = null;
			if(eeit45.group3.bakeyourlife.course.getOpenCourse() != null) {//有ID更新資料
				ps = conn.prepareStatement(SQL_UPDATE);
								
					ps.setString(1, eeit45.group3.bakeyourlife.course.getOpenCourse());
					ps.setString(2, eeit45.group3.bakeyourlife.course.getCourseID());
					ps.setDate(3, eeit45.group3.bakeyourlife.course.getStartDate());
					ps.setDate(4, eeit45.group3.bakeyourlife.course.getEndDate());
					ps.setString(5, eeit45.group3.bakeyourlife.course.getRoom());
					ps.setInt(6, eeit45.group3.bakeyourlife.course.getRegisterMax());
					ps.setString(7, eeit45.group3.bakeyourlife.course.getTeacher());
					ps.setString(8, eeit45.group3.bakeyourlife.course.getNote());
				
			}else {
				ps = conn.prepareStatement(SQL_INSERT);

					ps.setString(1, eeit45.group3.bakeyourlife.course.getOpenCourse());
					ps.setString(2, eeit45.group3.bakeyourlife.course.getCourseID());
					ps.setDate(3, eeit45.group3.bakeyourlife.course.getStartDate());
					ps.setDate(4, eeit45.group3.bakeyourlife.course.getEndDate());
					ps.setString(5, eeit45.group3.bakeyourlife.course.getRoom());
					ps.setInt(6, eeit45.group3.bakeyourlife.course.getRegisterMax());
					ps.setString(7, eeit45.group3.bakeyourlife.course.getTeacher());
					ps.setString(8, eeit45.group3.bakeyourlife.course.getNote());
				
			}
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	*/


