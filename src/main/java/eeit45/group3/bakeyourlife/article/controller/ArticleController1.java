package eeit45.group3.bakeyourlife.article.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;


/**
 * Servlet implementation class ArticleServlet
 */
//@WebServlet(urlPatterns = { 
//		"/Article/",
//		"/Article/QueryArticle",
//		"/Article/CreateArticle", 
//		"/Article/UpdateArticle", 
//		"/Article/DeleteArticle",
//		"/Picture",
//		"/Article/Art",
//		
//}, 
//initParams = { 
//		@WebInitParam(name = "ArticleIndexPath", value = "/JSP/article/Article.html"),
//		@WebInitParam(name = "QueryArticlePath", value = "/JSP/article/ShowArticle.html"),
//		@WebInitParam(name = "CreateArticlePath", value = "/JSP/article/CreateArticle.html"),
//		@WebInitParam(name = "UpdateArticlePath", value = "/JSP/article/UpdateArticle.html")
//})
//@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 定義檔案暫存門檻
//maxFileSize = 1024 * 1024 * 10, // 允許單個檔案最大大小；當上傳檔案大小超過定義會丟出 exception (IllegalStateException)
//maxRequestSize = 1024 * 1024 * 50 // 允許整個 multipart/form-data 要求最大大小；當上傳檔案大小超過定義會丟出 exception (IllegalStateException)
//)
@Controller
public class ArticleController1 {
//	private static final long serialVersionUID = 1L;
//	private String ArticleIndexPath;
//	private String QueryArticlePath;
//	private String CreateArticlePath;
//	private String UpdateArticlePath;
//	
//	 ArticleService articleservice = new ArticleServiceImpl();
//
//	public void init() throws ServletException {
//		/*
//		 * 初始化
//		 * */
//		ArticleIndexPath = getInitParameter("ArticleIndexPath");
//		QueryArticlePath = getInitParameter("QueryArticlePath");
//		CreateArticlePath = getInitParameter("CreateArticlePath");
//		UpdateArticlePath = getInitParameter("UpdateArticlePath");
//				
//	}
 
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleController1() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 		
//	          ArticleService articleservice = new ArticleServiceImpl();
//	          try {  
//		
//		 if (request.getServletPath().equals("/Article/")) {
//			 List<Article> listAll = articleservice.findAll();               
//	        	request.setAttribute("articles", listAll);
//		    	request.getRequestDispatcher(ArticleIndexPath).forward(request, response);
//	          } 
//		 else if (request.getServletPath().equals("/Article/QueryArticle")) {
//			 Integer postid = Integer.valueOf(request.getParameter("postid"));  
//			 List<Article> listone = articleservice.selectone(postid);
//			 //Article getone = articleservice.getPic(postid);
//			 Article article = listone.get(0);
//			 article.setCounter(article.getCounter()+1);
//			 articleservice.update(article);
//			    request.setAttribute("articles", listone);
//			 request.getRequestDispatcher(QueryArticlePath).forward(request, response);
//		 }
//		 else if (request.getServletPath().equals("/Article/CreateArticle")) {			  
//			 request.getRequestDispatcher(CreateArticlePath).forward(request, response);
//		 }
//		 else if (request.getServletPath().equals("/Article/UpdateArticle")) {
//			 Integer postid = Integer.valueOf(request.getParameter("postid"));  
//			 List<Article> listone = articleservice.selectone(postid);
//			  Article article = listone.get(0);
//			  article.setCounter(0);
//			    request.setAttribute("articles", listone);
//			 request.getRequestDispatcher(UpdateArticlePath).forward(request, response);
//		 }  
//		 else if (request.getServletPath().equals("/Article/DeleteArticle")) {
//			 
//				processDelete(request,response,articleservice);
//		 }		
//		 else if (request.getServletPath().equals("/Picture")) {
//			 
//			 processPicture(request,response,articleservice);
//		 }		
//		 else if (request.getServletPath().equals("/Article/Art")) {
//			 
//			 processFindOne(request,response,articleservice);
//		 }		
//		  } catch (SQLException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				
//				e.printStackTrace();
//			} 
//		 
//		}
//	
//   
//
//
//	public void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//      
//        try {
//        	
//        	ArticleService articleservice = new ArticleServiceImpl();
//       
//    	 	
//    	request.setCharacterEncoding("UTF-8");
// 
//    	if (request.getServletPath().equals("/Article/Art")) {
//    		processFindOne(request,response,articleservice);
//	
//    	} 
//    	else if (request.getServletPath().equals("/Article/QueryArticle")) {
//          processQuery(request,response,articleservice);
//        } 
//    	else if (request.getServletPath().equals("/Article/CreateArticle")) {
//            processInsert(request,response,articleservice);
//          } 
//    	else if (request.getServletPath().equals("/Article/UpdateArticle")) {
//          processUpdate(request,response,articleservice);
//        } 
//    	else if (request.getServletPath().equals("/Article/DeleteArticle")) {
//            processDelete(request,response,articleservice);
//          }        
//        else if (request.getServletPath().equals("/Picture/")) {
//			 
//			 processPicture(request,response,articleservice);
//		 }		
//       
//	  } catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		} 
//	 
//	}
        
//    @GetMapping(path = "/ArticleFindAll")
//    private List<Article> processFindOne(@RequestParam("postid") Integer postid , Model m) throws SQLException,IOException {
//    	 
//    
//    		
//         
//    	   ArticleService articleservice = new ArticleServiceImpl();
//    		 //String title = request.getParameter("title");
//    		 //List<Article> listone = articleservice.select(title);
//        	//m.addAttribute("article", listone); 
//        	List<Article> listAll = articleservice.findAll();               
//        	//m.addAttribute("articles", listAll); 
//			//request.getRequestDispatcher(ArticleIndexPath).forward(request, response);
//        	return "Article";
//    }
//		
//}
//        	
//    private void processQuery(HttpServletRequest request, 
//            HttpServletResponse response,
//            ArticleService articleservice) throws SQLException,IOException {
//    	 
//    	 try {
//    		 response.setContentType("image/gif");	 
//    			    		
//    		 //Integer postid = Integer.valueOf(request.getParameter("postid"));
//    		 //articleservice.selectone(postid);
//            
//            //response.setContentType("image/gif");
//        
//    		 String title = request.getParameter("title");
//            List<Article> listone = articleservice.select(title);         
//        	
//        	
//        	
//        	request.setAttribute("articles", listone);  
//			request.getRequestDispatcher(QueryArticlePath).forward(request, response);
//		} catch (ServletException e) {
//			
//			e.printStackTrace();
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//          
	}
// 
//    private void processInsert(HttpServletRequest request, HttpServletResponse response, ArticleService articleservice) throws SQLException,IOException{
//    	
//    	try {
//    		Map<String, String> errorMsg = new HashMap<>();
//    		String title = request.getParameter("title");
//        	String type = request.getParameter("type");
//        	String dates = request.getParameter("date");
//            String content = request.getParameter("content");       
//            //String base64Image = request.getParameter("picture");
//            Part picture = request.getPart("picture");
//            Integer counter = 0;
//    		
//       	   response.setContentType("image/gif");
//    		
//            BufferedInputStream bis = new BufferedInputStream(picture.getInputStream());
//            byte[] pic = new byte[bis.available()];
//            bis.read(pic);
//            
//      
//        Date date = null ;
//        if (dates == null || dates.trim().length() == 0) {
//			errorMsg.put("date", "請選擇發文日期");
//		} else {
//				try {
//					date = Date.valueOf(dates);								
//				}catch(IllegalArgumentException e) {
//					e.printStackTrace();
//					errorMsg.put("date", "日期應為yyyy-mm-dd");					
//				}
//		}
//        
//        if (title == null || title.trim().length() == 0) {
//			errorMsg.put("title", "標題不得為空");
//		}
//    	 if (type == null || type.trim().length() == 0) {
//    		 errorMsg.put("type", "請選擇文章分類");
//    	 }
//    	 if (date == null) {
//    		 errorMsg.put("date", "請選擇發文日期");
//    	 }
//    	if (content == null || content.trim().length() == 0) {
//   		 errorMsg.put("content", "請輸入內文");
//   	 }
//       if(errorMsg.size()>0) {
//    	   request.setAttribute("ErrorMsg", errorMsg);
//    	   request.getRequestDispatcher(CreateArticlePath).forward(request, response);    	   
//       }else {
//    	   Article newArticle = new Article(null,title,type,date,content,pic,counter);
//    	   articleservice.insert(newArticle);
//    	   //request.setAttribute("eeit45.group3.bakeyourlife.article", base64Image);
//    	   response.sendRedirect("./");    	   
//       }
    	
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		} catch (ServletException e) {
//			
//			e.printStackTrace();
//		}
//    	}
//
//     private void processUpdate(HttpServletRequest request, HttpServletResponse response, ArticleService articleservice) throws SQLException,IOException{
//    	 try {
//    	Integer postid = Integer.valueOf(request.getParameter("postid"));   	
//    	String title = request.getParameter("title");    	
//    	String type = request.getParameter("type");    	
//    	Date date = Date.valueOf(request.getParameter("date"));    	
//    	String content = request.getParameter("content");
//    	
//        
//        		
//        Part picture = request.getPart("picture");
//        Integer counter = 0;
//        BufferedInputStream bis = new BufferedInputStream(picture.getInputStream());
//        byte[] pic = new byte[bis.available()];
//        bis.read(pic);
//        
//   	
//    	
//    	
//    	Article upArticle = new Article(postid,title,type,date,content, pic,counter);
//    	articleservice.update(upArticle);
//
//    	 
//    	 response.sendRedirect("./");
//
//    	 
//    	 } catch (ServletException e) {
//			
//			e.printStackTrace();
//		}  
//    	
//		
//     }
//        
//    
//     private void processDelete(HttpServletRequest request, HttpServletResponse response, ArticleService articleservice) throws SQLException,IOException{
//    	 try {
//    	Integer postid = Integer.valueOf(request.getParameter("postid"));
//        
//        
//        
//    	articleservice.delete(postid);
//    	 
//          response.sendRedirect("./");
//		
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//        
//        
//     }
//     
// 
//private void processPicture(HttpServletRequest request, HttpServletResponse response, ArticleService articleservice) throws SQLException,IOException{
//	 try {
//	
//	response.setContentType("image/gif");	 
//	ServletOutputStream out = response.getOutputStream();
//	ArticleService svc = new ArticleServiceImpl();
//	Integer postid = Integer.valueOf(request.getParameter("postid"));
//	Article pic = svc.getPic(postid);
//	if (pic != null) {
//		out.write(pic.getPicture());;
//		request.setAttribute("articles", pic);
//		
//	}
//	
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//}  
//}  
     
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
