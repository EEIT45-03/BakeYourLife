package eeit45.group3.bakeyourlife.article.controller;


import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import eeit45.group3.bakeyourlife.article.model.Article;
import eeit45.group3.bakeyourlife.article.service.ArticleService;



@Controller
@RequestMapping(path = "/Article")
public class ArticleController {
 
	@Autowired
	private ArticleService articleservice;
	
//public ArticleController() {
//   
//  
//}


@GetMapping(path = "/")
   private String processFindOne(@RequestParam(required = false) Integer postid ,Model m){
     
    	List<Article> listAll = articleservice.findAll();               
    	m.addAttribute("articles", listAll); 
    	return "article/Article";
}


@GetMapping(path = "/QueryArticle")
public String processQuery(@ModelAttribute Article articleInfo,@RequestParam(required = false) Integer postid ,
		Model model,Article article) throws IOException {
	List<Article> listone = articleservice.selectone(postid);
	article = listone.get(0);
	article.setCounter(article.getCounter()+1);
	articleservice.update(article);
	 
	
	 String encoded64 = new String(article.getPicture()); 
	 article.setBase64(encoded64);
//	  String base64 = getBase64(listone.get(0).getPicture());
//	  model.addAttribute("contentImage",base64);
		model.addAttribute("articles",listone);
		return "article/ShowArticle";

}

//		public String getBase64(byte[] picture)throws UnsupportedEncodingException {
//			byte[] encodeBase64 = Base64.encodeBase64(picture);
//			String base64Encoded = new String(encodeBase64, "UTF-8");
//			return base64Encoded;
//		}


@GetMapping("/CreateArticle")
   public String viewInsert(Model model) {
	//表單綁定用
	
	model.addAttribute("article",new Article());
	return "article/CreateArticle";
}



@PostMapping(path = "/CreateArticle")
  public String processInsert(@ModelAttribute Article articleInfo,@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "date", required = false) Date date,
			@RequestParam(value = "content", required = false) String content,
			@RequestParam(value = "articleImage", required = false) MultipartFile file,
			@RequestParam(value = "counter", required = false) Integer counter,Article article,Model model) { 
	  articleInfo.setCounter(0);
	  articleInfo.setArticleImage(file);
	  try{
        byte[] image = Base64.encodeBase64(articleInfo.getArticleImage().getBytes());
        String result = new String(image);
        System.out.println(result);
        articleInfo.setPicture(image);
    } catch(Exception e) {
        e.printStackTrace();
    }

	articleservice.insert(articleInfo);
    return "redirect:./";
}	      
//	
//	Map<String, String> errorMsg = new HashMap<>();
//	if (title == null || title.trim().length() == 0) {
//		errorMsg.put("title", "標題不得為空");
//	}
//	if (type == null || type.trim().length() == 0) {
//		errorMsg.put("type", "請選擇文章分類");
//	}
//	if (date == null) {
//		errorMsg.put("date", "請選擇發文日期");
//	}
//	if (content == null || content.trim().length() == 0) {
//		errorMsg.put("content", "請輸入內文");
//	}
//	if (errorMsg.size() > 0) {
//		m.addAttribute("ErrorMsg", errorMsg);
//		return "CreateArticle";
//	}
////	} else {
////		m.addAttribute("title",article.getTitle());
////		m.addAttribute("type",article.getType());
////		m.addAttribute("date",article.getDate());
////		m.addAttribute("content",article.getContent());
////		m.addAttribute("picture",article.getPicture());
////		m.addAttribute("counter", 0);
	

@GetMapping("/UpdateArticle")
public String viewUpdate(@RequestParam(required = false) Integer postid,Model model,Article article) {
	//表單綁定用
	
	//Article getPic = articleservice.getPic(postid);
	List<Article> listone = articleservice.selectone(postid); 
	String encoded64 = new String(listone.get(0).getPicture()); 
	listone.get(0).setBase64(encoded64);
	 model.addAttribute("articles", listone); 
	return "article/UpdateArticle";
}

@PostMapping("/UpdateArticle")
public String processUpdate(@ModelAttribute Article articleInfo,@RequestParam(required = false) Integer postid,@RequestParam(value = "title", required = false) String title,@RequestParam(value = "type", required = false) String type,
		@RequestParam(value = "date", required = false) Date date,
		@RequestParam(value = "content", required = false) String content,@RequestParam(value = "picture", required = false)byte[] picture,@RequestParam(value = "base64", required = false)String base64,
		@RequestParam(value = "articleImage", required = false) MultipartFile file,
		@RequestParam(value = "counter", required = false) Integer counter,Model model)  throws IOException{{ 
  
	//List<Article> listone = articleservice.selectone(postid);	
	
	
			
  articleInfo.setArticleImage(file);
  try{
    byte[] image = Base64.encodeBase64(articleInfo.getArticleImage().getBytes());
    String result = new String(image);
    System.out.println(result);
    articleInfo.setPicture(image);
} catch(Exception e) {
    e.printStackTrace();
}	
	
  Article upArticle = new Article(postid,title,type,date,content, articleInfo.getPicture(),file,base64,0);   
     articleservice.update(upArticle);
     //Integer counter = 0;	
		}

     return "redirect:./"; 
	
}

@PostMapping("/DeleteArticle")
public ResponseEntity<?> processDelete(@RequestParam("postid") Integer postid){
	articleservice.delete(postid);
	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	
}
}

	



   




