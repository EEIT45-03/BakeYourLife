package eeit45.group3.bakeyourlife.article.controller;

import eeit45.group3.bakeyourlife.article.model.Article;
import eeit45.group3.bakeyourlife.article.model.Message;
import eeit45.group3.bakeyourlife.article.service.ArticleService;
import eeit45.group3.bakeyourlife.article.service.MessageService;
import eeit45.group3.bakeyourlife.article.validator.ArticleValidator;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping(path = "/admin/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;


    @GetMapping(path = "/")
    private String processFindOne(@RequestParam(required = false) Integer messageId, Model m,Message message) {

        List<Message> messageAll = messageService.findMessageAll();
//        String encoded64 = new String(message.getImage());
//        message.setBase64Message(encoded64);
        m.addAttribute("messages", messageAll);
        return "admin/article/Message";

    }

    @GetMapping("/CreateMessage")
    public String viewInsert(Model model) {
        //表單綁定用

        model.addAttribute("message", new Article());
        return "admin/article/CreateMessage";
    }


    @PostMapping(path = "/CreateMessage")
    public String processInsert(@Valid @ModelAttribute("message") Message articleInfo,
                                BindingResult bindingResult,
                                @RequestParam(value = "articleImage", required = false) MultipartFile file
    ) {

//	List<ObjectError> list0 = bindingResult.getAllErrors();
//	for (ObjectError error : list0) {
//		System.out.println("有錯誤：" + error);
//	}
        //ModelAndView model = new ModelAndView("customerDone");
        if (bindingResult.hasErrors()) {
            //model = new ModelAndView("customerCreate");
            //return model;
            return "admin/article/CreateMessage";
        }




        if (bindingResult.hasErrors()) {

            return "admin/article/CreateMessage";
        }


        articleInfo.setMessageImage(file);
        try{
            byte[] image = Base64.encodeBase64(articleInfo.getMessageImage().getBytes());
            String result = new String(image);
            System.out.println(result);
            articleInfo.setImage(image);
        } catch(Exception e) {
            e.printStackTrace();
        }

        messageService.insert(articleInfo);
        return "redirect:./";
    }

    @GetMapping("/UpdateMessage")
    public String viewUpdate(@RequestParam(required = false) Integer messageId,Model model) {
        //表單綁定用


        Message message = messageService.messageOne(messageId).orElse(null);
        String encoded64 = new String( message.getImage());
        message.setBase64Message(encoded64);
        model.addAttribute("article", message);
        return "admin/article/UpdateMessage";
    }

    @PostMapping("/UpdateMessage")
    public String processUpdate(@ModelAttribute ("message") Message articleInfo,
                                @RequestParam(value = "articleImage", required = false) MultipartFile file,
                                Model model)  throws IOException {{





        articleInfo.setMessageImage(file);
        try{
            byte[] image = Base64.encodeBase64(articleInfo.getMessageImage().getBytes());
            String result = new String(image);
            System.out.println(result);
            articleInfo.setImage(image);
        } catch(Exception e) {
            e.printStackTrace();
        }

        //Article upArticle = new Article(postid,title,type,date,content, articleInfo.getPicture(),file,base64,0);

        messageService.update(articleInfo);
        //Integer counter = 0;
    }

        return "redirect:./";

    }

    @PostMapping("/DeleteMessage")
    public String processDelete(@RequestParam("messageId") Integer messageId){
        messageService.delete(messageId);
        return "redirect:./";
        //ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        // java.sql.Date
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat2.setLenient(false);
        CustomDateEditor ce2 = new CustomDateEditor(dateFormat2, true);
        binder.registerCustomEditor(java.sql.Date.class, ce2);
    }
}

