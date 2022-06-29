package eeit45.group3.bakeyourlife.course.controller;/*
 * package eeit45.group3.bakeyourlife.course.controller;
 * 
 * import java.io.IOException; import java.util.List;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebInitParam; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import eeit45.group3.bakeyourlife.course.main.Course; import
 * eeit45.group3.bakeyourlife.course.main.CourseService; import
 * eeit45.group3.bakeyourlife.course.main.CourseServiceImpl;
 * 
 *//**
	 * Servlet implementation class OrderController
	 */
/*
 * @WebServlet(urlPatterns = {"/Course/"}, initParams = {
 * 
 * @WebInitParam(name = "CourseIndexPath", value = "/JSP/Course/Course.jsp") }
 * 
 * ) //The value attribute is recommended for use when the URL pattern is the
 * only attribute being set, otherwise the urlPattern attribute should be used.
 * public class CourseController extends HttpServlet { private static final long
 * serialVersionUID = 1L;
 * 
 * private String CourseIndexPath;
 * 
 * 
 * CourseService courseService;
 * 
 * 
 * @Override public void init() throws ServletException { //OrderIndexPath =
 * getInitParameter("OrderIndexPath"); CourseIndexPath =
 * getInitParameter("CourseIndexPath"); // courseDao = (CourseDao)
 * getServletContext().getAttribute("courseDao");
 * 
 * courseService = new CourseServiceImpl(); }
 * 
 *//**
	 * @see HttpServlet#HttpServlet()
	 */
/*
 * public CourseController() { super(); // TODO Auto-generated constructor stub
 * }
 * 
 *//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
/*
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * 
 * 
 * if(request.getServletPath().equals("/Course/")) {
 * 
 * List<Course> courses = courseService.findAll();
 * request.setAttribute("courses", courses);
 * request.getRequestDispatcher(CourseIndexPath).forward(request, response); } }
 * 
 *//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
		 * protected void doPost(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { // TODO Auto-generated
		 * method stub doGet(request, response); }
		 * 
		 * }
		 */