package eeit45.group3.bakeyourlife.course.controller;//package eeit45.group3.bakeyourlife.course.controller;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import eeit45.group3.bakeyourlife.course.main.CourseService;
//import eeit45.group3.bakeyourlife.course.main.CourseServiceImpl;
//
///**
// * Servlet implementation class DeleteOrderController
// */
//
//@WebServlet("/Course/CourseDelete")
//public class DeleteCourseController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	
//	CourseService courseService;
//	       
//    @Override
//	public void init() throws ServletException {
//		// TODO Auto-generated method stub
//    	
//    	courseService = new CourseServiceImpl();
//	}
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public DeleteCourseController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String OpenCourse = request.getParameter("openCourse");
//		
//		courseService.deleteCourse(Integer.valueOf(OpenCourse));
//		response.sendRedirect(".");
//		//doGet(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		//doGet(request, response);
////		String OpenCourse = request.getParameter("OpenCourse");
////		;
////		courseDao.deleteById(OpenCourse);
////		response.sendRedirect(".");
//		doGet(request, response);
//	}
//
//}
