package eeit45.group3.bakeyourlife.user.controller; // package
                                                    // eeit45.group3.bakeyourlife.user.controller;
//
// import java.io.IOException;
//
// import java.util.List;
//
// import javax.servlet.ServletConfig;
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebInitParam;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import eeit45.group3.bakeyourlife.user.model.User;
// import eeit45.group3.bakeyourlife.user.service.UserService;
// import eeit45.group3.bakeyourlife.user.service.UserServiceImpl;
//
/// **
// * Servlet implementation class UserController
// */
// @WebServlet(urlPatterns = {
//		"/User/",
//		"/User/CreateUser",
//		"/User/UpdateUser",
//		"/User/DeleteUser",
//		"/User/CheckUser"},
// initParams = {
//		@WebInitParam(name = "UserIndexPath", value = "/JSP/user/UserOld.jsp"),
//		@WebInitParam(name = "CreateUserPath", value = "/JSP/user/CreateUserOld.jsp"),
//		@WebInitParam(name = "UpdateUserPath", value = "/JSP/user/UpdateUserOld.jsp") })
// public class UserControllerold extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private String UserIndexPath;
//	private String CreateUserPath;
//	private String UpdateUserPath;
//	UserService us;
//
//	/**
//	 * @see Servlet#init(ServletConfig)
//	 */
//	public void init() throws ServletException {
//		UserIndexPath = getInitParameter("UserIndexPath");
//		CreateUserPath = getInitParameter("CreateUserPath");
//		UpdateUserPath = getInitParameter("UpdateUserPath");
//		us = new UserServiceImpl();
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		if (request.getServletPath().equals("/User/")) {
//			List<User> userBeans = us.findAll();
//			// 設置給jsp使用
//			request.setAttribute("users", userBeans);
//			request.getRequestDispatcher(UserIndexPath).forward(request, response);
//		} else if (request.getServletPath().equals("/User/CreateUser")) {
//			request.getRequestDispatcher(CreateUserPath).forward(request, response);
//		} else if (request.getServletPath().equals("/User/UpdateUser")) {
//			/*
//			 * 先查詢要更新的userid存不存在 如果user為null，代表parameter為空或輸入的userid錯誤
//			 */
//			String parameter = request.getParameter("userId").trim();
//			User ub = null;
//			if (parameter != null) {
//				ub = us.findByUserId(Integer.valueOf(parameter));
//			}
//			if (ub != null) {
//				// 設置給jsp使用
//				request.setAttribute("user", ub);
//				request.getRequestDispatcher(UpdateUserPath).forward(request, response);
//			} else {
//				response.sendRedirect("./");
//			}
//		} else if (request.getServletPath().equals("/User/DeleteUser")) {
//			deleteUser(request, response);
//		}else if (request.getServletPath().equals("/User/CheckUser")) {
//			checkUser(request, response);
//	}
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		if (request.getServletPath().equals("/User/CreateUser")) {
//			insertUser(request, response);
//		} else if (request.getServletPath().equals("/User/UpdateUser")) {
//			updateUser(request, response);
//		} else if (request.getServletPath().equals("/User/DeleteUser")) {
//			deleteUser(request, response);
//		} else if (request.getServletPath().equals("/User/CheckUser")) {
//			checkUser(request, response);
//		}
//
//	}
//
//	private void insertUser(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String userName = request.getParameter("userName");
//		String password = request.getParameter("password");
//		String fullName = request.getParameter("fullName");
//		String email = request.getParameter("email");
//		String phone = request.getParameter("phone");
//		String birth = request.getParameter("birth");
//		String gender = request.getParameter("gender");
//		String pcode = request.getParameter("pcode");
//		String city = request.getParameter("city");
//		String dist = request.getParameter("dist");
//		String fulladdress = request.getParameter("fulladdress");
//		String address = pcode+city+dist+fulladdress;
//		User ub = new User(userName, password, fullName, email, phone, birth, gender, address);
//		us.save(ub);
//		response.sendRedirect("./");
//
//	}
//
//	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String parameter = request.getParameter("userId").trim();
//		if (parameter != null) {
//			int userId = Integer.parseInt(parameter);
//			us.deleteByUserId(userId);
//			response.sendRedirect("./");
//		}
//	}
//
//	private void updateUser(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		int userId = Integer.parseInt(request.getParameter("userId"));
//		String userName = request.getParameter("userName");
//		String password = request.getParameter("password");
//		String fullName = request.getParameter("fullName");
//		String email = request.getParameter("email");
//		String phone = request.getParameter("phone");
//		String birth = request.getParameter("birth");
//		String gender = request.getParameter("gender");
//		String address = request.getParameter("address");
//		User ub = new User(userId, userName, password, fullName, email, phone, birth, gender, address);
//		us.updateUser(ub);
//		response.sendRedirect("./");
//	}
//	private void checkUser(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException{
//		User user = us.findByUserName(request.getParameter("userName"));
//		System.out.println(user);
//		if (user==null) {
//			response.getWriter().write("true");
//		}
////		response.setContentType("text/html");
////	      boolean flag = false;
////	    String userName=request.getParameter("userName").toString();
////		    flag = us.userIsExist(userName);
////	   if(true == flag){
////	          response.getWriter().write("true");//此值jquery可以接收到
////	    }
//	}
// }
//
