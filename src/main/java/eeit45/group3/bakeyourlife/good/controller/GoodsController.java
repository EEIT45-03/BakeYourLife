package eeit45.group3.bakeyourlife.good.controller;//package eeit45.group3.bakeyourlife.good.controller;
//
//import java.io.BufferedInputStream;
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.Part;
//
//import eeit45.group3.bakeyourlife.good.model.Goods;
//import eeit45.group3.bakeyourlife.good.service.GoodService;
//import eeit45.group3.bakeyourlife.good.service.impl.GoodServiceHibernateImpl;
///**
// * Servlet implementation class GoodsController
// */
//@WebServlet(
//		urlPatterns = { 
//				"/Goods/", 
//				"/Goods/CreateGoods", 
//				"/Goods/UpdateGoods", 
//				"/Goods/DeleteGoods",
//				"/Goods/CheckGoods",
//				"/picture"
//				
//		}, 
//		initParams = { 
//				@WebInitParam(name = "GoodsIndexPath", value = "/JSP/goods/Goods.jsp"), 
//				@WebInitParam(name = "CreateGoodsPath", value = "/JSP/goods/CreateGoods.jsp"), 
//				@WebInitParam(name = "UpdateGoodsPath", value = "/JSP/goods/UpdateGoods.jsp")
//		})
//@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
//maxFileSize = 1024 * 1024 * 10, // 10MB
//maxRequestSize = 1024 * 1024 * 50) // 50MB
//public class GoodsController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private String GoodsIndexPath;
//	private String CreateGoodsPath;
//	private String UpdateGoodsPath;
//	private GoodService goodService;
//	
// 
////    public GoodsController() {
////        super();
////    }
//
//
//	public void init() throws ServletException {
//		GoodsIndexPath = getInitParameter("GoodsIndexPath");
//    	CreateGoodsPath = getInitParameter("CreateGoodsPath");
//    	UpdateGoodsPath = getInitParameter("UpdateGoodsPath");
//    	goodService = new GoodServiceHibernateImpl();
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////		GoodsDao goodsDao = new GoodsDao();
//		if(request.getServletPath().equals("/Goods/")) {
//			List<Goods> goods = goodService.getAllMembers();
//			
//			//設置給jsp使用
//			request.setAttribute("goods", goods);
//			request.getRequestDispatcher(GoodsIndexPath).forward(request, response);
//	}else if(request.getServletPath().equals("/Goods/CreateGoods")) {
//		request.getRequestDispatcher(CreateGoodsPath).forward(request, response);
//	}else if(request.getServletPath().equals("/Goods/UpdateGoods")){
//		/*
//		 * 先查詢要更新的orderId存不存在
//		 * 如果order為null，代表parameter為空或輸入的orderId錯誤
//		 * */
//		String parameter = request.getParameter("id").trim();
//		Goods goods=null;
//		if(parameter!=null) {
//			goods =  goodService.getMember(Integer.valueOf(parameter));
//		}
//		if(goods!=null) {
//			//設置給jsp使用
//			request.setAttribute("goods", goods);
//			request.getRequestDispatcher(UpdateGoodsPath).forward(request, response);			
//		}else {
//			response.sendRedirect("./");
//		}
//	}else if(request.getServletPath().equals("/Goods/DeleteGoods")) {
//		processDeleteGoods(request, response);			
//	}else if(request.getServletPath().equals("/Goods/CheckGoods")) {
//		checkName(request,response);			
//	}else if(request.getServletPath().equals("/picture")) {
//		processpicture(request,response);
//}
//}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if(request.getServletPath().equals("/Goods/CreateGoods")) {
//			processCreateGoods(request,response);
//		}else if(request.getServletPath().equals("/picture")) {
//				processpicture(request,response);
//		}else if(request.getServletPath().equals("/Goods/UpdateGoods")) {
//			processUpdateGoods(request, response);
//		}else if(request.getServletPath().equals("/Goods/DeleteGoods")) {
//			processDeleteGoods(request, response);			
//		}else if(request.getServletPath().equals("/Goods/CheckGoods")) {
//			checkName(request,response);			
//		}
//	}
//private void processCreateGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////GoodService goodService = new GoodServiceHibernateImpl();
//		String name = request.getParameter("name");
//		String element = request.getParameter("element");
//		String origin = request.getParameter("origin");
//		String savetime = request.getParameter("savetime");
//		String packages = request.getParameter("packages");
//		String packagematerial = request.getParameter("packagematerial");
//		String saveway = request.getParameter("saveway");
//		
//		Part part = request.getPart("picture");
//		BufferedInputStream bis = new BufferedInputStream(part.getInputStream());
//		byte[] pic = new byte[bis.available()];
//		bis.read(pic);
//;		
//		Goods goods = new Goods(name,element,origin,savetime,packages,packagematerial,saveway,pic);
//		goodService.save(goods);
//		response.sendRedirect("./");		
// }
//private void processUpdateGoods(HttpServletRequest request, HttpServletResponse response)
//		throws ServletException, IOException {
////	GoodsDao goodsDao = new GoodsDao();
//	// TODO Auto-generated method stub
//	int id = Integer.parseInt(request.getParameter("id"));
//	String name = request.getParameter("name").trim();
//	String element = request.getParameter("element").trim();
//	String origin = request.getParameter("origin").trim();
//	String savetime = request.getParameter("savetime").trim();
//	String packages = request.getParameter("packages").trim();
//	String packagematerial = request.getParameter("packagematerial").trim();
//	String saveway = request.getParameter("saveway").trim();
//	
//	Part part = request.getPart("picture");
//	BufferedInputStream bis = new BufferedInputStream(part.getInputStream());
//	byte[] pic = new byte[bis.available()];
//	bis.read(pic);
//	
//	Goods goods = new Goods(id, name, element, origin, savetime, packages, packagematerial,saveway,pic);
//	goodService.updateMember(goods);
//	response.sendRedirect("./");//問一下跟按鈕的關西;
//}
//private void processDeleteGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	String parameter = request.getParameter("id").trim();//問這個!!
//	if(parameter!=null) {
//		int id = Integer.parseInt(parameter);
////		GoodsDao goodsDao = new GoodsDao();
//		goodService.deleteMember(id);
//		response.sendRedirect("./");
//	}
//	//改用AJAX
////	response.sendRedirect("./");
//}
//private void checkName(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  
//{
//// response.setContentType("text/html");  
////      GoodsDao goodsDao = new GoodsDao(); //初始化類
//Goods goods =goodService.isDup(request.getParameter("name"));
//    System.out.println(goods);
//    if (goods != null) {
//		
//    	response.getWriter().write("true");//此值jquery可以接收到  
//	}
//}
////boolean flag = false;  
//
////    String id=request.getParameter("name");  
////
////     flag = goodService.isDup(id);  //必須初始化類才可以用
////System.out.println(flag);
////   if(true == flag)  
////
////      {  
////
////          response.getWriter().write("true");//此值jquery可以接收到  
////
////
////    }  
//// 
//private void processpicture(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  
//{
//
//	request.setCharacterEncoding("UTF-8");
//	response.setContentType("image/gif");
//	ServletOutputStream out = response.getOutputStream();
////	GoodsDao dao = new GoodsDao();
//	Integer id = Integer.valueOf(request.getParameter("id"));
//	Goods bean = goodService.getMember(id);
//
//	if (bean != null) {
//		out.write(bean.getPicture());
//	}
//
//}
//}
