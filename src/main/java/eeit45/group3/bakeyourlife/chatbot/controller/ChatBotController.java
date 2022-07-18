package eeit45.group3.bakeyourlife.chatbot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/webhook")
    public Object webhook(@RequestBody String bodyStr) throws JsonProcessingException {
//        System.out.println(bodyStr);
        Map body = objectMapper.readValue(bodyStr, Map.class);
        Map queryResult = (Map) body.get("queryResult");
        Map parameters = (Map)queryResult.get("parameters");


        Object map = objectMapper.readValue("{\n" +
                "  \"fulfillmentMessages\": [\n" +
                "    {\n" +
                "      \"payload\": {\n" +
                "        \"richContent\": [\n" +
                "          [\n" +
                "            {\n" +
                "              \"type\": \"info\",\n" +
                "              \"title\": \"Info item title\",\n" +
                "              \"subtitle\": \"Info item subtitle\",\n" +
                "              \"image\": {\n" +
                "                \"src\": {\n" +
                "                  \"rawUrl\": \"https://example.com/images/logo.png\"\n" +
                "                }\n" +
                "              },\n" +
                "              \"actionLink\": \"https://example.com\"\n" +
                "            }\n" +
                "          ],\n" +
                "          [\n" +
                "            {\n" +
                "              \"type\": \"description\",\n" +
                "              \"title\": \"Description title\",\n" +
                "              \"text\": [\n" +
                "                \"This is text line 1.\",\n" +
                "                \"This is text line 2.\"\n" +
                "              ]\n" +
                "            }\n" +
                "          ],\n" +
                "          [\n" +
                "            {\n" +
                "              \"type\": \"image\",\n" +
                "              \"rawUrl\": \"https://example.com/images/logo.png\",\n" +
                "              \"accessibilityText\": \"Example logo\"\n" +
                "            }\n" +
                "          ],\n" +
                "          [\n" +
                "            {\n" +
                "              \"type\": \"button\",\n" +
                "              \"icon\": {\n" +
                "                \"type\": \"chevron_right\",\n" +
                "                \"color\": \"#FF9800\"\n" +
                "              },\n" +
                "              \"text\": \"Button text\",\n" +
                "              \"link\": \"https://example.com\",\n" +
                "              \"event\": {\n" +
                "                \"name\": \"\",\n" +
                "                \"languageCode\": \"\",\n" +
                "                \"parameters\": {\n" +
                "                  \n" +
                "                }\n" +
                "              }\n" +
                "            }\n" +
                "          ],\n" +
                "          [\n" +
                "            {\n" +
                "              \"type\": \"list\",\n" +
                "              \"title\": \"List item 1 title\",\n" +
                "              \"subtitle\": \"List item 1 subtitle\",\n" +
                "              \"event\": {\n" +
                "                \"name\": \"\",\n" +
                "                \"languageCode\": \"\",\n" +
                "                \"parameters\": {\n" +
                "                  \n" +
                "                }\n" +
                "              }\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"divider\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"list\",\n" +
                "              \"title\": \"List item 2 title\",\n" +
                "              \"subtitle\": \"List item 2 subtitle\",\n" +
                "              \"event\": {\n" +
                "                \"name\": \"\",\n" +
                "                \"languageCode\": \"\",\n" +
                "                \"parameters\": {\n" +
                "                  \n" +
                "                }\n" +
                "              }\n" +
                "            }\n" +
                "          ],\n" +
                "          [\n" +
                "            {\n" +
                "              \"type\": \"accordion\",\n" +
                "              \"title\": \"Accordion title\",\n" +
                "              \"subtitle\": \"Accordion subtitle\",\n" +
                "              \"image\": {\n" +
                "                \"src\": {\n" +
                "                  \"rawUrl\": \"https://example.com/images/logo.png\"\n" +
                "                }\n" +
                "              },\n" +
                "              \"text\": \"Accordion text\"\n" +
                "            }\n" +
                "          ],\n" +
                "          [\n" +
                "            {\n" +
                "              \"type\": \"chips\",\n" +
                "              \"options\": [\n" +
                "                {\n" +
                "                  \"text\": \"Chip 1\",\n" +
                "                  \"image\": {\n" +
                "                    \"src\": {\n" +
                "                      \"rawUrl\": \"https://example.com/images/logo.png\"\n" +
                "                    }\n" +
                "                  },\n" +
                "                  \"link\": \"https://example.com\"\n" +
                "                },\n" +
                "                {\n" +
                "                  \"text\": \"Chip 2\",\n" +
                "                  \"image\": {\n" +
                "                    \"src\": {\n" +
                "                      \"rawUrl\": \"https://example.com/images/logo.png\"\n" +
                "                    }\n" +
                "                  },\n" +
                "                  \"link\": \"https://example.com\"\n" +
                "                }\n" +
                "              ]\n" +
                "            }\n" +
                "          ]\n" +
                "        ]\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}", Object.class);


//        Map<String,>


        Map<String, Object> response = new HashMap<>();
        Map<String,Object> payload = new HashMap<>();
        Map<String,Object> richContent = new HashMap<>();
        List<Object> message = new ArrayList<>();
        payload.put("payload", richContent);
        richContent.put("richContent",message);
        List list = new ArrayList();
        list.add(payload);
        response.put("fulfillmentMessages", list);








        return response;

    }


    private List getInfoMessage(String title,String subtitle,String image,String actionLink){
        List list = new ArrayList();
        Map<String,Object> message = new HashMap<>();
        message.put("type", "info");
        message.put("title", title);
        message.put("subtitle", subtitle);
        Map<String,Object> imageMap = new HashMap<>();
        Map<String,Object> imageSrc = new HashMap<>();
        imageSrc.put("rawUrl", image);
        imageMap.put("src", imageSrc);
        message.put("image", imageMap);
        message.put("actionLink", actionLink);
        list.add(message);
        return list;
    }

    private List getDescriptionMessage(String title,List<String> text){
        List list = new ArrayList();
        Map<String,Object> message = new HashMap<>();
        message.put("type", "description");
        message.put("title", title);
        message.put("text", text);
        list.add(message);
        return list;
    }

    private List getImageMessage(String title,String imageUrl,String accessibilityText){
        List list = new ArrayList();
        Map<String,Object> message = new HashMap<>();
        message.put("type", "image");
        message.put("rawUrl", imageUrl);
        message.put("accessibilityText", accessibilityText);
        list.add(message);
        return list;
    }

    private List getButtonMessage(String iconType,String iconColor,String text,String link,
                                  String eventName,String eventLanguageCode,Map<String,Object> eventParameters){
        List list = new ArrayList();
        Map<String,Object> message = new HashMap<>();
        message.put("type", "button");
        Map<String,String> icon = new HashMap<>();
        icon.put("type", iconType);
        icon.put("color", iconColor);
        message.put("icon", icon);
        message.put("text", text);
        message.put("link", link);
        Map<String,Object> event = new HashMap<>();
        event.put("name", eventName);
        event.put("languageCode", eventLanguageCode);
        event.put("parameters", eventParameters);
        list.add(message);
        return list;
    }

    private List getListMessage(String title,String subtitle,String eventName,String eventLanguageCode,Map<String,Object> eventParameters){
        List list = new ArrayList();
        Map<String,Object> message = new HashMap<>();
        message.put("type", "list");
        message.put("title", title);
        message.put("subtitle", subtitle);
        Map<String,Object> event = new HashMap<>();
        event.put("name", eventName);
        event.put("languageCode", eventLanguageCode);
        event.put("parameters", eventParameters);
        message.put("event", event);
        list.add(message);
        return list;
    }

    //分隔線
    private List getDividerMessage(){
        List list = new ArrayList();
        Map<String,Object> message = new HashMap<>();
        message.put("type", "divider");
        list.add(message);
        return list;
    }

}