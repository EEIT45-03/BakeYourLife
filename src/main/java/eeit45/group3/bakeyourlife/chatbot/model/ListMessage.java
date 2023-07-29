package eeit45.group3.bakeyourlife.chatbot.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListMessage {
  private List<Object> root;

  public ListMessage() {
    this.root = new ArrayList();
  }

  public void addMessage(
      String title,
      String subtitle,
      String eventName,
      String eventLanguageCode,
      Map<String, Object> eventParameters) {
    Map<String, Object> message = new HashMap<>();
    message.put("type", "list");
    message.put("title", title);
    message.put("subtitle", subtitle);
    Map<String, Object> event = new HashMap<>();
    event.put("name", eventName);
    event.put("languageCode", eventLanguageCode);
    event.put("parameters", eventParameters);
    message.put("event", event);
    this.root.add(message);
  }

  public void addDividerMessage() {
    Map<String, Object> message = new HashMap<>();
    message.put("type", "divider");
    this.root.add(message);
  }

  public List<Object> getRoot() {
    return root;
  }
}
