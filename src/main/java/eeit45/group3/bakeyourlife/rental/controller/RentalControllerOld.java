package eeit45.group3.bakeyourlife.rental.controller;

//import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import eeit45.group3.bakeyourlife.rental.model.Rental;
//import eeit45.group3.bakeyourlife.rental.service.RentalService;
//import eeit45.group3.bakeyourlife.rental.service.RentalServiceImpl;


//@WebServlet(urlPatterns = {"/Rental/"},
//initParams = { 
//		@WebInitParam(name = "RentalIndexPath", value = "/JSP/rental/Rental.jsp"),
//		})
public class RentalControllerOld extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//    
//	private String RentalIndexPath;
//	
//	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
//	private static final String CHARSET_CODE = "UTF-8";
//	
////	private RentalDAO rentalDAO;
//	private RentalService rentalService;
//	
//	
//	
//    public RentalController() {
//        super();
//    }
//    
//    
//    @Override
// 	public void init() throws ServletException {
//    	RentalIndexPath = getInitParameter("RentalIndexPath");
//    	rentalService = new RentalServiceImpl();
// 	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding(CHARSET_CODE);
//		response.setContentType(CONTENT_TYPE);
//
////		response.setHeader("Cache-Control", "no-cache");
////		response.setHeader("Pragma", "no-cache");
////		response.setDateHeader("Expires", -1);
//
//		
//		if(request.getServletPath().equals("/Rental/")) {
////			rentalDAO = new RentalDAOimp();
////			List<Integer> clients = rentalDAO.getSelectClient();
////			request.setAttribute("clients", clients);
//			
//			if(request.getParameter("insert") != null) {
//				processInsert(request, response);
//				response.sendRedirect(".");
//			}
//			
//			else if(request.getParameter("delete") != null) {
//				processDelete(request, response);
//				response.sendRedirect(".");
//			}
//			
//			else if(request.getParameter("update") != null) {
//				processUpdate(request, response);
//				response.sendRedirect(".");
//			}else {
//				processSelect(request, response);				
//			}
//		}
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//		
//	}
//
//	
//	private void processInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//		Rental rental = new Rental();
//		
//		rental.setClient_id(request.getParameter("client_id").trim());
//		rental.setLocation(request.getParameter("location").trim());
//		rental.setDatestart(stringToDate(request.getParameter("datestart").trim(), "yyyy-MM-dd'T'HH:mm"));
//		rental.setDateend(stringToDate(request.getParameter("dateend").trim(), "yyyy-MM-dd'T'HH:mm"));
//		rental.setQuantity(Integer.valueOf(request.getParameter("quantity").trim()));
//		rental.setPrice(Integer.valueOf(request.getParameter("price").trim()));
//		rentalService.createRental(rental);
//	}
//	
//	private void processDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		int rental_id_del = Integer.valueOf(request.getParameter("rental_id_delete"));
//		rentalService.deleteRental(rental_id_del);
//	}
//	
//	private void processUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		Rental rental = rentalService.findById(Integer.valueOf(request.getParameter("rental_id_update").trim()));
////		if(request.getParameter("rental_id_update") != null)
////			eeit45.group3.bakeyourlife.rental.setRental_id(Integer.valueOf(request.getParameter("rental_id_update").trim()));
//		if(request.getParameter("client_id_update") != null)
//			rental.setClient_id(request.getParameter("client_id_update").trim());
//		if(request.getParameter("location_update") != null)
//			rental.setLocation(request.getParameter("location_update").trim());
//		if(request.getParameter("datestart_update") != null)
//			rental.setDatestart(stringToDate(request.getParameter("datestart_update").trim(), "yyyy-MM-dd HH:mm"));
//		if(request.getParameter("dateend_update") != null)
//			rental.setDateend(stringToDate(request.getParameter("dateend_update").trim(), "yyyy-MM-dd HH:mm"));
//		if(request.getParameter("quantity_update") != null)
//			rental.setQuantity(Integer.valueOf(request.getParameter("quantity_update").trim()));
//		if(request.getParameter("price_update") != null)
//			rental.setPrice(Integer.valueOf(request.getParameter("price_update").trim()));
//		rentalService.updateRental(rental);
//
//	}
//	private void processSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
////		Map<String,String> rental_sel = new HashMap<String, String>();
////		
////		if(request.getParameter("rentalIds") != null)
////		rental_sel.put("rental_id",request.getParameter("rentalIds"));
////		if(request.getParameter("clientIds") != null)
////			rental_sel.put("client_id",request.getParameter("clientIds"));
////		if(request.getParameter("locations") != null)
////			rental_sel.put("location",request.getParameter("locations"));
////		if(request.getParameter("dateStarts") != null)
////			rental_sel.put("datestart",request.getParameter("dateStarts"));
////		if(request.getParameter("dateEnds") != null)
////			rental_sel.put("dateend",request.getParameter("dateEnds"));
////		if(request.getParameter("quantitys") != null)
////			rental_sel.put("quantity",request.getParameter("quantitys"));
////		if(request.getParameter("prices") != null)
////			rental_sel.put("price",request.getParameter("prices"));
//
//
//		List<Rental> rentals = rentalService.findAll();
//		request.setAttribute("rentals", rentals);	
////		rentalDAO.getRentalProperty(rentals, request);
//		request.getRequestDispatcher(RentalIndexPath).forward(request, response);
//	}
//	
//	public Date stringToDate(String data, String format) {
//		SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
//		java.util.Date datetime = null;
//		try {
//			datetime = dateFormatter.parse(data);
//		} catch (ParseException e) {
//			System.err.println("date:" + datetime + ",異常" + e);
//			e.printStackTrace();
//		}
//		return datetime;
//	}

}
