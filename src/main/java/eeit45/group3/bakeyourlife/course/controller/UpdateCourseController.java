package eeit45.group3.bakeyourlife.course.controller;//package eeit45.group3.bakeyourlife.course.controller;
//
//import java.io.IOException;
//import java.sql.Date;
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
//
//
///**
// * Servlet implementation class UpdateOrderController
// */
//@WebServlet("/Course/UpdateCourse")
//public class UpdateCourseController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	
//	CourseService courseService;
//
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
//    public UpdateCourseController() {
//        super();
//        
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		String parameter = request.getParameter("openCourse");
////		System.out.println(parameter);
//		if(parameter!=null) {
//			Course course = courseService.findCourseById(Integer.valueOf(parameter))
//					.orElseThrow(() ->  new ServletException("沒有找到要更新的課程"));
//			request.setAttribute("course", course);
//		}
//		request.getRequestDispatcher("/JSP/Course/UpdateCourse.jsp").forward(request, response);
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
////	    Enumeration params = request.getParameterNames();
////		while(params.hasMoreElements()) {
////		    String param = (String) params.nextElement();
////
////		    	String[] parameterValues = request.getParameterValues(param);
////		    	for (String string : parameterValues) {
////		    		System.out.println(param + " = " +  string);		    						
////				}
////
////		}
//	    OpenCourse = request.getParameter("openCourse").trim();
//	    CourseID = request.getParameter("CourseID").trim();
//	    //System.out.println(CourseID);
//	    SDate = request.getParameter("StartDate").trim();
//	    EDate = request.getParameter("EndDate").trim();
//	    Room = request.getParameter("Room").trim();
//	    RegisterMax = request.getParameter("RegisterMax").trim();
//	    Teacher = request.getParameter("Teacher").trim();
//	    Note = request.getParameter("Note").trim();
//				
//		
//		Course course = new Course();
//		
//		//Date 格式轉換
//		//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			//surround below line with try catch block as below code throws checked exception
//			
////		    Date StartDate=null;
////			Date EndDate=null;
////			try {
////				StartDate = (Date) sdf.parse(SDate);
////				EndDate = (Date) sdf.parse(EDate);
////			} catch (ParseException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}   
//		
//		
//		course.setOpenCourse(Integer.valueOf(OpenCourse));
//		course.setCourseID(CourseID);
//		course.setStartDate(Date.valueOf(SDate));
//		course.setEndDate(Date.valueOf(EDate));
//		course.setRoom(Room);
//		course.setRegisterMax(Integer.valueOf(RegisterMax));
//		course.setTeacher(Teacher);
//		course.setNote(Note);
//		
//		
//		courseService.updateCourse(course);
//		
//		response.sendRedirect("./");
//	}
//
//}
