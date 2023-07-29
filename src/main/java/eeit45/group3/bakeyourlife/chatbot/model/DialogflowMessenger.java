package eeit45.group3.bakeyourlife.chatbot.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** https://cloud.google.com/dialogflow/es/docs/integrations/dialogflow-messenger#rich */
public class DialogflowMessenger {

  Map<String, Object> response;
  List<Object> message;

  public DialogflowMessenger() {
    Map<String, Object> response = new HashMap<>();
    this.response = response;
    Map<String, Object> payload = new HashMap<>();
    Map<String, Object> richContent = new HashMap<>();
    List<Object> message = new ArrayList<>();
    this.message = message;
    payload.put("payload", richContent);
    richContent.put("richContent", message);
    List list = new ArrayList();
    list.add(payload);
    response.put("fulfillmentMessages", list);
  }

  public DialogflowMessenger(String text) {
    Map<String, Object> response = new HashMap<>();
    this.response = response;
    response.put("fulfillmentText", text);
  }

  public Map<String, Object> getResponse() {
    return response;
  }

  public void addInfoMessage(String title, String subtitle, String image, String actionLink) {
    List list = new ArrayList();
    Map<String, Object> message = new HashMap<>();
    message.put("type", "info");
    message.put("title", title);
    message.put("subtitle", subtitle);
    Map<String, Object> imageMap = new HashMap<>();
    Map<String, Object> imageSrc = new HashMap<>();
    imageSrc.put("rawUrl", image);
    imageMap.put("src", imageSrc);
    message.put("image", imageMap);
    message.put("actionLink", actionLink);
    list.add(message);
    this.message.add(list);
  }

  public void addDescriptionMessage(String title, List<String> text) {
    List list = new ArrayList();
    Map<String, Object> message = new HashMap<>();
    message.put("type", "description");
    message.put("title", title);
    message.put("text", text);
    list.add(message);
    this.message.add(list);
  }

  public void addImageMessage(String title, String imageUrl, String accessibilityText) {
    List list = new ArrayList();
    Map<String, Object> message = new HashMap<>();
    message.put("type", "image");
    message.put("rawUrl", imageUrl);
    message.put("accessibilityText", accessibilityText);
    list.add(message);
    this.message.add(list);
  }

  public void addButtonMessage(
      String iconType,
      String iconColor,
      String text,
      String link,
      String eventName,
      String eventLanguageCode,
      Map<String, Object> eventParameters) {
    List list = new ArrayList();
    Map<String, Object> message = new HashMap<>();
    message.put("type", "button");
    Map<String, String> icon = new HashMap<>();
    icon.put("type", iconType);
    icon.put("color", iconColor);
    message.put("icon", icon);
    message.put("text", text);
    message.put("link", link);
    Map<String, Object> event = new HashMap<>();
    event.put("name", eventName);
    event.put("languageCode", eventLanguageCode);
    event.put("parameters", eventParameters);
    list.add(message);
    this.message.add(list);
  }

  public void addAccordionMessage(String title, String subtitle, String image, String text) {
    List list = new ArrayList();
    Map<String, Object> message = new HashMap<>();
    message.put("type", "accordion");
    message.put("title", title);
    message.put("subtitle", subtitle);
    Map<String, Object> imageMap = new HashMap<>();
    Map<String, Object> imageSrc = new HashMap<>();
    imageSrc.put("rawUrl", image);
    imageMap.put("src", imageSrc);
    message.put("image", imageMap);
    message.put("text", text);
    list.add(message);
    this.message.add(list);
  }

  public void addListMessage(ListMessage listMessage) {
    this.message.add(listMessage.getRoot());
  }

  public void addChipsMessage(Option option) {
    List list = new ArrayList();
    Map<String, Object> message = new HashMap<>();
    message.put("type", "chips");

    message.put("options", option.getOptions());
    list.add(message);
    this.message.add(list);
  }
}
