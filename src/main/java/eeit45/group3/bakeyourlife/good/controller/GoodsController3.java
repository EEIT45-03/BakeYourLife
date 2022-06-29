package eeit45.group3.bakeyourlife.good.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import eeit45.group3.bakeyourlife.good.model.Goods;
import eeit45.group3.bakeyourlife.good.service.GoodService;

@Controller
@RequestMapping(path = "/Goods")
public class GoodsController3 {
	
	
	private GoodService goodService;
	private ServletContext context;
	@Autowired
	public GoodsController3(GoodService goodService, ServletContext context) {
		super();
		this.goodService = goodService;
		this.context = context;
	}

	@GetMapping("/")
	public String viewGoods(Model m) {
		List<Goods> goods = goodService.getAllGoods();
		m.addAttribute("goods", goods);
		return "goods/Goods";
	}
	
	@GetMapping("/CreateGoods")
	public String viewCreateGoods(Model m){
		m.addAttribute("Goods",new Goods());
		return "goods/CreateGoods";
	}
	
	@PostMapping("/add")
	public String viewCreateGoods1(@ModelAttribute("Goods") Goods good){
		for (int i = 0; i < 5; i++) {
			System.out.println("Catch imfo");
		}	
		MultipartFile picture = good.getProductImage();
		// 建立Blob物件，交由 Hibernate 寫入資料庫
		String originalFilename =picture.getOriginalFilename();
		if (originalFilename.length() >0 && originalFilename.lastIndexOf(".")> -1 ) {
			good.setFileName(originalFilename);
		}
		if (picture != null && !picture.isEmpty()) {
			try {
				byte[] b = picture.getBytes();
				Blob blob = new SerialBlob(b);
				good.setImage(blob);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}
		Timestamp adminTime = new Timestamp(System.currentTimeMillis());
		good.setAdmissionTime(adminTime);
		goodService.save(good);
		return "redirect:./";
	}
	
	@GetMapping("/DeleteGoods")//標籤有改
	public String delete(@RequestParam("id") int ipk) {//標籤有改 為何抓的到ID
		goodService.deleteGoods(ipk);
		return "redirect:./";
	}
	
	@PostMapping("/CheckGoods")
	@ResponseBody
	public boolean CheckGoods(@RequestParam("name") String name) {
		Goods dup = goodService.isDup(name);
		if(dup==null) {
			return false;
		}else {
			return true;
		}
	}
	
	
	@GetMapping(value = "/UpdateGoods")
	public String viewUpdateUser(@RequestParam("id") int id,Model model) {
 		Goods good = goodService.getGoods(id);
 		model.addAttribute("Goods",good);
//     	goodService.updateMember(goodService.getMember(id));
//		model.addAttribute("name",good.getName());
//		model.addAttribute("element", good.getElement());
//		model.addAttribute("origin", good.getOrigin());
//		model.addAttribute("savetime", good.getSavetime());
//		model.addAttribute("packages", good.getPackages());
//		model.addAttribute("picture", good.getImage());
//		model.addAttribute("packagematerial", good.getPackagematerial());
//		model.addAttribute("saveway", good.getSaveway());
		return "goods/UpdateGoods";
		
	}
	@PostMapping(value = "/UpdateGoods")
	public String viewUpdateUser2(@RequestParam("id") int id,Model model,
			                      @ModelAttribute("Goods") Goods good){
		good.setId(id);
		
		MultipartFile picture = good.getProductImage();
		if (picture.getSize() == 0) {
			// 表示使用者並未挑選圖片
			Goods goodDb = goodService.getGoods(id);
			good.setImage(goodDb.getImage());
//			Member original = memberService.get(id);
//			member.setImage(original.getImage());
		}else {
			
		
		// 建立Blob物件，交由 Hibernate 寫入資料庫
		String originalFilename =picture.getOriginalFilename();
		if (originalFilename.length() >0 && originalFilename.lastIndexOf(".")> -1 ) {
			good.setFileName(originalFilename);
		}
		if (picture != null && !picture.isEmpty()) {
			try {
				byte[] b = picture.getBytes();
				Blob blob = new SerialBlob(b);
				good.setImage(blob);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}
		}
		Timestamp adminTime = new Timestamp(System.currentTimeMillis());
		good.setAdmissionTime(adminTime);
		
		goodService.updateGoods(good);
		return "redirect:./";
	}
	
	//取照片
			@GetMapping("/crm/picture/{id}")
			public ResponseEntity<byte[]> getPicture(@PathVariable("id") Integer id) {
				byte[] body = null;
				ResponseEntity<byte[]> re = null;
				MediaType mediaType = null;
				HttpHeaders headers = new HttpHeaders();
				headers.setCacheControl(CacheControl.noCache().getHeaderValue());

				Goods goods = goodService.getGoods(id);
				if (goods == null) {
					return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
				}
			
				
				String filename = goods.getFileName();
				if (filename != null) {
					if (filename.toLowerCase().endsWith("jfif")) {
						mediaType = MediaType.valueOf(context.getMimeType("dummy.jpeg"));
					} else {
						mediaType = MediaType.valueOf(context.getMimeType(filename));
						headers.setContentType(mediaType);
					}
				}
				Blob blob = goods.getImage();
				
				try {
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					InputStream is = blob.getBinaryStream();
					byte[] b = new byte[81920];
					int len = 0;
					while ((len = is.read(b)) != -1) {
						baos.write(b, 0, len);
					}
					headers.setContentType(mediaType);
					headers.setCacheControl(CacheControl.noCache().getHeaderValue());
					re = new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.OK);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return re;
}
}
