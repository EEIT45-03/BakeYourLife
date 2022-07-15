package eeit45.group3.bakeyourlife.good.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.rowset.serial.SerialBlob;

import eeit45.group3.bakeyourlife.utils.ImgurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import eeit45.group3.bakeyourlife.good.model.Goods;
import eeit45.group3.bakeyourlife.good.service.GoodService;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping(path = "/admin/Goods")
public class GoodsControllerServerSide {


	private GoodService goodService;
	private ServletContext context;
	@Autowired
	public GoodsControllerServerSide(GoodService goodService, ServletContext context) {
		super();
		this.goodService = goodService;
		this.context = context;
	}

	@GetMapping("/")
	public String viewGoods(Model m) {
		List<Goods> goods = goodService.getAllGoods();
		m.addAttribute("goods", goods);
		return "admin/goods/GoodsServerSide";
	}

	@GetMapping("/CreateGoods")
	public String viewCreateGoods(Model m){
		m.addAttribute("Goods",new Goods());
		return "admin/goods/CreateGoodsServerSide";
	}

	@PostMapping("/CreateGoods")
	public String viewCreateGoods1(@ModelAttribute("Goods") Goods good){

		MultipartFile[] productImage = good.getProductImage();
//		good.setImageUrl("");
		for(MultipartFile cmf:productImage){
		String link = ImgurService.updateByMultipartFile(cmf).getLink();
		if(good.getImageUrl() == null || "".equals(good.getImageUrl())){
		good.setImageUrl(link);
		}else {
		good.setImageUrl(good.getImageUrl() + "," + link);
		}
		}
		// 建立Blob物件，交由 Hibernate 寫入資料庫
//		String originalFilename =picture.getOriginalFilename();
//		if (originalFilename.length() >0 && originalFilename.lastIndexOf(".")> -1 ) {
//			good.setFileName(originalFilename);
//		}
//		if (picture != null && !picture.isEmpty()) {
//			try {
//				byte[] b = picture.getBytes();
//				Blob blob = new SerialBlob(b);
//				good.setImage(blob);
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
//			}
//		}
		Timestamp adminTime = new Timestamp(System.currentTimeMillis());
		good.setAdmissionTime(adminTime);
		goodService.save(good);
		return "redirect:./";
	}

//	@GetMapping("/DeleteGoods")//標籤有改
//	public String delete(@RequestParam("id") int ipk) {//標籤有改 為何抓的到ID
//		goodService.deleteGoods(ipk);
//		return "redirect:./";
//	}

	@DeleteMapping("/GoodsServerSide/{id}")
	private ResponseEntity<?> deleteGoodsProduct(@PathVariable Integer id) {
		goodService.deleteGoods(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PostMapping("/CheckGoods")
	@ResponseBody
	public boolean CheckGoods(@RequestParam("name") String name,
							  @RequestParam(required = false) Integer id) {
		Goods dup = goodService.isDup(name);

		if(dup!=null && id == null){
			return true;
		}else
		if(dup != null){
			Goods goods = goodService.getGoods(id);
			if(goods!=null && dup.getName().equals(goods.getName())){
				return false;
			}else return dup.getId() != goods.getId();
		}
		return false;
	}

//	@PostMapping("/CheckGoods1")
////	@ResponseBody
//	public ResponseEntity<Goods> returnGoods(@RequestParam("name") Integer name) {
//		Goods dup = goodService.getGoods(name);
//		return ResponseEntity.status(HttpStatus.OK).body(dup);
//	}

	@PostMapping("/CheckGoods1")
	@ResponseBody
	public Goods goods1(@RequestParam("name") Integer name) {
		Goods dup = goodService.getGoods(name);
		return goodService.getGoods(name);
	}

	@GetMapping(value = "/UpdateGoods")
	public String viewUpdateUser(@RequestParam("id") int id,Model model) {
		Goods good = goodService.getGoods(id);
		model.addAttribute("Goods",good);

		return "admin/goods/UpdateGoodsServerSide";

	}

	@GetMapping(value = "/Picture")
	public String picture(@RequestParam("id") int id,Model model){
		Goods good = goodService.getGoods(id);
		model.addAttribute("Goods",good);
		return "admin/goods/PictureServerSide";
	}

	@PostMapping(value = "/UpdateGoods")
	public String viewUpdateUser2(@RequestParam("id") int id,Model model,
								  @ModelAttribute("Goods") Goods good){
		good.setId(id);



		MultipartFile[] productImage = good.getProductImage();
		MultipartFile picture = productImage[0];
		if (picture.getSize() == 0) {
			// 表示使用者並未挑選圖片
			Goods goodDb = goodService.getGoods(id);
			good.setImageUrl(goodDb.getImageUrl());
//			good.setImage(goodDb.getImage());

		}else {
//		String link = ImgurService.updateByMultipartFile(picture).getLink();
//		good.setImageUrl(link);
//			MultipartFile[] productImage = good.getProductImage();
//		good.setImageUrl("");
			for(MultipartFile cmf:productImage){
				String link = ImgurService.updateByMultipartFile(cmf).getLink();
				if(good.getImageUrl() == null || "".equals(good.getImageUrl())){
					good.setImageUrl(link);
				}else {
					good.setImageUrl(good.getImageUrl() + "," + link);
				}
			}


			// 建立Blob物件，交由 Hibernate 寫入資料庫
//			String originalFilename =picture.getOriginalFilename();
//			if (originalFilename.length() >0 && originalFilename.lastIndexOf(".")> -1 ) {
//				good.setFileName(originalFilename);
//			}
//			if (picture != null && !picture.isEmpty()) {
//				try {
//					byte[] b = picture.getBytes();
//					Blob blob = new SerialBlob(b);
//					good.setImage(blob);
//				} catch (Exception e) {
//					e.printStackTrace();
//					throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
//				}
//			}
		}
		Timestamp adminTime = new Timestamp(System.currentTimeMillis());
		good.setAdmissionTime(adminTime);

		goodService.updateGoods(good);
		return "redirect:./";
	}

	//取照片
//	@GetMapping("/picture")
//	public ResponseEntity<byte[]> getPicture(@RequestParam("id") Integer id) {
//		byte[] body = null;
//		ResponseEntity<byte[]> re = null;
//		MediaType mediaType = null;
//		HttpHeaders headers = new HttpHeaders();
//		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
//
//		Goods goods = goodService.getGoods(id);
//		if (goods == null) {
//			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
//		}
//
//
//		String filename = goods.getFileName();
////		if (filename != null) {
////			if (filename.toLowerCase().endsWith("jfif")) {
////				mediaType = MediaType.valueOf(context.getMimeType("dummy.jpeg"));
////			} else {
////				mediaType = MediaType.valueOf(context.getMimeType(filename));
////				headers.setContentType(mediaType);
////			}
////		}
//		Blob blob = goods.getImage();
//
//		try {
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			InputStream is = blob.getBinaryStream();
//			byte[] b = new byte[81920];
//			int len = 0;
//			while ((len = is.read(b)) != -1) {
//				baos.write(b, 0, len);
//			}
//			headers.setContentType(mediaType);
//			headers.setCacheControl(CacheControl.noCache().getHeaderValue());
//			re = new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return re;
//	}
}
