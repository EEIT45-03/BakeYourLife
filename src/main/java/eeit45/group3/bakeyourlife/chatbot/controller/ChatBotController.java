package eeit45.group3.bakeyourlife.chatbot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eeit45.group3.bakeyourlife.chatbot.model.DialogflowMessenger;
import eeit45.group3.bakeyourlife.chatbot.model.ListMessage;
import eeit45.group3.bakeyourlife.chatbot.model.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ChatBotController {
    /**
     * 然後參考老師的教學設定，ngrok的port改8080，在Fulfillment的Webhook修改為對應的網址(看ngrok的Forwarding)
     */

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/webhook")
    public Object webhook(@RequestBody String bodyStr) throws JsonProcessingException {

        Map body = objectMapper.readValue(bodyStr, Map.class);
        Map queryResult = (Map) body.get("queryResult");
        Map parameters = (Map) queryResult.get("parameters");

        DialogflowMessenger dialogflowMessenger = new DialogflowMessenger();

        /**
         * Info 訊息
         */
        dialogflowMessenger.addInfoMessage("Info標題","內文","https://i.imgur.com/N42uCxU.jpg","http://localhost:8080/FrontArticle/ArticleDetail?postid=1");


        /**
         * Description 訊息
         */
        List<String> description = new ArrayList<>();
        description.add("內文一");
        description.add("內文二");
        description.add("內文三");
        description.add("內文四");
        dialogflowMessenger.addDescriptionMessage("Description標題",description);

        /**
         * Image 訊息
         */
        dialogflowMessenger.addImageMessage("Image標題","https://i.imgur.com/N42uCxU.jpg","圖片的替換文字");

        /**
         * Icon Type : https://fonts.google.com/icons?selected=Material+Icons
         * Button 訊息
         */
        dialogflowMessenger.addButtonMessage("Home","#FF9800","Button文字","http://localhost:8080/",null,null,null);


        /**
         * Accordion 訊息
         * 伸縮訊息
         */
        dialogflowMessenger.addAccordionMessage("Accordion標題","內文","https://i.imgur.com/N42uCxU.jpg","藏起來的文字");

        /**
         * List 訊息
         */
        ListMessage listMessage = new ListMessage();
        listMessage.addMessage("List標題","內文",null,null,null);
        listMessage.addDividerMessage();//分隔線
        listMessage.addMessage("List標題","內文",null,null,null);
        listMessage.addDividerMessage();//分隔線
        listMessage.addMessage("List標題","內文",null,null,null);
        dialogflowMessenger.addListMessage(listMessage);


        /**
         * Chips 訊息
         */
        Option option = new Option();
        option.addOption("Chips選項一","https://i.imgur.com/N42uCxU.jpg","http://localhost:8080/");
        option.addOption("Chips選項二","https://i.imgur.com/N42uCxU.jpg","http://localhost:8080/");
        option.addOption("Chips選項三","https://i.imgur.com/N42uCxU.jpg","http://localhost:8080/");
        dialogflowMessenger.addChipsMessage(option);

        return dialogflowMessenger.getResponse();

    }

}