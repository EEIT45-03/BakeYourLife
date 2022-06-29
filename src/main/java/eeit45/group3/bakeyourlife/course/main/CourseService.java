package eeit45.group3.bakeyourlife.course.main;


import java.util.List;
import java.util.Optional;



public interface CourseService {
	
	//查詢定單區間
		//List<Order> findAllByOrderDateBetween( Date orderDateStart, Date orderDateEnd);
		
		/*
		 * 用商品名稱找訂單
		 * 
		 */
		
		//List<Order> findAllByItemName(String itemName);

		//用使用者ID查詢所有訂單
		//List<Order> findAllByMemNo(Integer memNo);

		//查詢所有課程
		List<Course> findAll();
		
		//用訂單類型找訂單
		//List<Order> findAllByOrderType(Integer orderType);
		
		//用訂單狀態找訂單
		//List<Order> findAllByOrderStatus(Integer orderStatus);
		
		//用PK找訂單
		Optional<Course> findCourseById(Integer OpenCourse);
		
		//用訂單編號找訂單
		//Optional<Order> findByOrderNo(String orderNo);
		

		//用開課編號刪除課程
		void deleteCourse(Integer OpenCourse);

		//更新課程
		void updateCourse(Course Course);
		
		//建立課程
		void createCourse(Course Course);
		
		//void addOrderItem(OrderItem orderItem);
}
