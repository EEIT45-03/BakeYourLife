package eeit45.group3.bakeyourlife.course.controller;//package eeit45.group3.bakeyourlife.course.controller;
//
//import java.io.IOException;
//import java.sql.Date;
////import java.eeit45.group3.util.Date;
//import java.util.Enumeration;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import eeit45.group3.bakeyourlife.course.main.Course;
//import eeit45.group3.bakeyourlife.course.main.CourseService;
//import eeit45.group3.bakeyourlife.course.main.CourseServiceImpl;
//
///**
// * Servlet implementation class CreateOrderController
// */
////@WebServlet("/Course/CreateCourse")
//public class CreateCourseController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	
//	CourseService courseService;
//	
//	   
//    public void init() throws ServletException {
//		// TODO Auto-generated method stub
////    	courseDao = (CourseDao) getServletContext().getAttribute("courseDao");
//    	
//    	courseService = new CourseServiceImpl();
//	}
//
//	/**
//     * @see HttpServlet#HttpServlet()
//     */
//    public CreateCourseController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		Enumeration params = request.getParameterNames();
//		while(params.hasMoreElements()) {
//		    String param = (String) params.nextElement();
//
//		    	String[] parameterValues = request.getParameterValues(param);
//		    	for (String string : parameterValues) {
//		    		System.out.println(param + " = " +  string);		    						
//				}
//
//		}
//		System.out.println();
//		request.getRequestDispatcher("/JSP/Course/CreateCourse.jsp").forward(request, response);
//		
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		String OpenCourse;
//	    String CourseID;
//	    String SDate;
//	    String EDate;
//	    String Room;
//	    String RegisterMax;
//	    String Teacher;
//	    String Note;	    
//	   
//	    //OpenCourse = request.getParameter("OpenCourse").trim();
//	    CourseID = request.getParameter("CourseID").trim();
//	    SDate = request.getParameter("StartDate").trim();
//	    EDate = request.getParameter("EndDate").trim();
//	    Room = request.getParameter("Room").trim();
//	    RegisterMax = request.getParameter("RegisterMax").trim();
////	    System.out.println(request.getParameter("RegisterMax"));
//	    Teacher = request.getParameter("Teacher").trim();
//	    Note = request.getParameter("Note").trim();
//				
//		
//		Course course = new Course();
//		
//		//Date 格式轉換
////			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			//surround below line with try catch block as below code throws checked exception
//			/*
//			Date StartDate=null;
//			Date EndDate=null;
//			try {
//				StartDate = sdf.parse(SDate);
//				EndDate = sdf.parse(EDate);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}*/
////		DateFormat df = new SimpleDateFormat("MMdd");
////		Calendar cal=Calendar.getInstance();
////	    Integer end = Integer.parseInt((int) (Math.random()*(9999-1000+1)+1000));
////	    eeit45.group3.bakeyourlife.course.setOpenCourse(openCourse);
//		
////		Calendar cal=Calendar.getInstance();
////		String yearString = new SimpleDateFormat("yyyyMMdd").format(date);
////		int year = Integer.parseInt(yearString);
////		int end = (int) (Math.random()*(9999-1000+1)+1000);
////		eeit45.group3.bakeyourlife.course.setOpenCourse(monthAndDay + end );
//		
////		eeit45.group3.bakeyourlife.course.setOpenCourse(OpenCourse);
//		course.setCourseID(CourseID);
//		course.setStartDate(Date.valueOf(SDate));
//		course.setEndDate(Date.valueOf(EDate));
//		course.setRoom(Room);
//		course.setRegisterMax(Integer.valueOf(RegisterMax));
//		course.setTeacher(Teacher);
//		course.setNote(Note);
//		//eeit45.group3.bakeyourlife.order.setOrderType(orderType);
//		
//		//eeit45.group3.bakeyourlife.order.setShippingFee(Integer.valueOf(shippingFee));
//		//eeit45.group3.bakeyourlife.order.setTotalPrice(Integer.valueOf(totalPrice));
//		
//		//int orderId = orderService.createOrder(eeit45.group3.bakeyourlife.order);
//		/*
//		for(int i = 0;i<productNo.length;i++) {
//			OrderItem orderItem = new OrderItem();
//			orderItem.setOrderId(orderId);
//			orderItem.setProductName(productName[i]);
//			orderItem.setProductNo(Integer.valueOf(productNo[i]));
//			orderItem.setQty(Integer.valueOf(qty[i]));
//			orderItem.setSubTotal(Integer.valueOf(subTotal[i]));
//			orderService.addOrderItem(orderItem);
//		}
//		*/
//		courseService.createCourse(course);
//		
//		response.sendRedirect("./");
//		
//		
//	}
//
//}
