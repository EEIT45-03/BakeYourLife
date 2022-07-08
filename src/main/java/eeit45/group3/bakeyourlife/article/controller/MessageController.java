package eeit45.group3.bakeyourlife.article.controller;

import eeit45.group3.bakeyourlife.article.model.Article;
import eeit45.group3.bakeyourlife.article.model.Message;
import eeit45.group3.bakeyourlife.article.service.ArticleService;
import eeit45.group3.bakeyourlife.article.service.MessageService;
import eeit45.group3.bakeyourlife.article.validator.ArticleValidator;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
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
}
