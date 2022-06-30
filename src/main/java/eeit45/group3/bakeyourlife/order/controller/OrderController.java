package eeit45.group3.bakeyourlife.order.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eeit45.group3.bakeyourlife.order.ecpay.EcpayPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.service.OrderService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.*;

@Controller
public class OrderController {
	
	

	private OrderService orderService;
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping("/Order/ECPAY/Result")
	public String result(@RequestParam("RtnCode") String rtnCode,
			@RequestParam("MerchantTradeNo") String merchantTradeNo,
						 RedirectAttributes model) {
		System.out.println("RtnCode: " + rtnCode);
		System.out.println("MerchantTradeNo: " + merchantTradeNo);
		
		Order order = orderService.findByOrderNo(merchantTradeNo).orElse(null);
		if(rtnCode.equals("1")) {
			if(order!=null) {
				Order pay = orderService.pay(order.getOrderId());
			}
		}
		model.addFlashAttribute("orderNo", order.getOrderNo());
		return "redirect:/Order/PaySuccess";
	}

	@GetMapping ("/Order/PAYPAL/Result")
	public String resultPaypal(@RequestParam String token,
							   RedirectAttributes  model) {
		System.out.println("Token: " + token);
		String orderNo = captureOrder(token);
		Order order = orderService.findByOrderNo(orderNo).orElse(null);
		if(order!=null) {
				Order pay = orderService.pay(order.getOrderId());
		}
		model.addFlashAttribute("orderNo", order.getOrderNo());
		return "redirect:/Order/PaySuccess";
	}

	@GetMapping("/Order/PaySuccess")
	public String paySuccess(){
		return "order/PaySuccess";
	}

	@GetMapping(value = "/Order/{orderNo}/Pay",produces = "text/html;charset=UTF-8")
	public ResponseEntity<String> pay(@PathVariable String orderNo, HttpServletRequest request){
		Order order = orderService.findByOrderNo(orderNo).orElse(null);
		String baseURL = request.getRequestURL().substring(0, request.getRequestURL().length() - request.getRequestURI().length()) + request.getContextPath();
		if(order!=null){
			switch (order.getPayType()){
				case ECPAY:
					String ecpayUrl =  baseURL + "/Order/ECPAY/Result";
					System.out.println("ecpayUrl:" + ecpayUrl);
					String string = EcpayPayment.genAioCheckOutALL(order, ecpayUrl);
					return new ResponseEntity<>(string, HttpStatus.OK);
				case PAYPAL:
					String paypalUrl =  baseURL + "/Order/PAYPAL/Result";
					System.out.println("paypalUrl:" + paypalUrl);
					return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(createPayUrl(order,paypalUrl))).build();
			}
		}
		return null;
	}


	@PostMapping("/Order/{orderNo}/Ship")
	public ResponseEntity<Order> deliver(@RequestParam String trackingNumber,
									   @PathVariable String orderNo){

		Order order = orderService.findByOrderNo(orderNo).orElse(null);
		if(order == null){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"訂單編號不存在");
		}
		Order deliver = orderService.deliver(order.getOrderId(), trackingNumber);

		return ResponseEntity.status(HttpStatus.OK).body(deliver);

	}

	@PostMapping("/Order/{orderNo}/Refund")
	public ResponseEntity<Order> refund(@RequestParam String choose,
										 @PathVariable String orderNo){
		Order order = orderService.findByOrderNo(orderNo).orElse(null);
		if(order == null){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"訂單編號不存在");
		}
		Order refund = null;
		if(choose.equals("accept")){
			refund = orderService.accept(order.getOrderId());
		} else if (choose.equals("reject")) {
			refund = orderService.reject(order.getOrderId());
		}

		return ResponseEntity.status(HttpStatus.OK).body(refund);
	}



	private ObjectMapper objectMapper = new ObjectMapper();

	public String getBearerToken() throws JsonProcessingException {


		String uri = "https://api-m.sandbox.paypal.com/v1/oauth2/token?grant_type=client_credentials";
		String username = "AesYSP7qlkdrNuhIikeK7xp0OfYnwu_O3jbaE5u_sHM4TzEbzee5u9uBLuMOeBWHHcN_zsxBMi_bEg0A";
		String password = "EIEbQo6Ax_VUfVpy-G-_QRKYel8jsnrrhSmeKV8bV57QBffmrpZhILDU03owotA1f87FVLKgadPkmi4v";
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth(username,password);
		headers.add("Accept", "application/json");
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("grant_type","client_credentials");
		ResponseEntity<String> response = restTemplate.exchange
				(uri, HttpMethod.POST, new HttpEntity<Object>(body, headers), String.class);
		Map map = objectMapper.readValue(response.getBody(), Map.class);
		return (String) map.get("access_token");
	}

	public String createPayUrl(Order order, String url){

		String json = "{\n" +
				"   \"intent\":\"CAPTURE\",\n" +
				"   \"application_context\":{\n" +
				"     \"brand_name\":\"烘焙工作坊\",\n" +
				"     \"return_url\": \"" + url + "\",\n" +
				"      \"cancel_url\": \"" + url + "\",\n" +
				"      \"locale\":\"zh-TW\"\n" +
				"     \n" +
				"   },\n" +
				"   \"purchase_units\":[\n" +
				"      {\n" +
				"         \"amount\":{\n" +
				"            \"currency_code\":\"TWD\",\n" +
				"            \"value\":\""+ order.getTotalPrice() +"\"\n" +
				"         },\n" +
				"        \"custom_id\":\"" + order.getOrderNo() + "\"\n" +
				"      }\n" +
				"     \n" +
				"   ]\n" +
				"}";

		String uri = "https://api-m.sandbox.paypal.com/v2/checkout/orders";
		RestTemplate restTemplate = new RestTemplate();
		String approveUri = null;
		try {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(getBearerToken());
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<String> response = restTemplate.exchange
				(uri, HttpMethod.POST, new HttpEntity<Object>(json, headers), String.class);
		Map map = objectMapper.readValue(response.getBody(), Map.class);

		List<Map<String,String>> links = (List<Map<String, String>>) map.get("links");

		for (Map<String, String> link : links) {
			if(link.get("rel").equals("approve")){
				approveUri = link.get("href");
				System.out.println(approveUri);
			}
		}
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		return approveUri;
	}

	/**
	 *
	 * @param token
	 * @return
	 * orderNo 訂單編號
	 */
	public String captureOrder(String token){
		String uri = "https://api-m.sandbox.paypal.com/v2/checkout/orders/"+ token +"/capture";
		RestTemplate restTemplate = new RestTemplate();
		String orderNo = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setBearerAuth(getBearerToken());
			headers.setContentType(MediaType.APPLICATION_JSON);
			ResponseEntity<String> response = restTemplate.exchange
					(uri, HttpMethod.POST, new HttpEntity<>(headers), String.class);
			Map map = objectMapper.readValue(response.getBody(), Map.class);
			List<Object> list;
			Map<Object,Object> maptemp;

			list = (List<Object>) map.get("purchase_units");

			maptemp = (Map<Object, Object>) list.get(0);

			maptemp = (Map<Object, Object>) maptemp.get("payments");

			list = (List<Object>) maptemp.get("captures");

			Map<Object, Object> captures = (Map<Object, Object>) list.get(0);

			if(captures.get("status").equals("COMPLETED")){
				orderNo = (String) captures.get("custom_id");
			}

			System.out.println(captures.get("status") + " " + captures.get("custom_id"));

		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		return orderNo;
	}


	
}
