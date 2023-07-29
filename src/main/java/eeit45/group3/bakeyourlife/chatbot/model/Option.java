package eeit45.group3.bakeyourlife.chatbot.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Option {
  private List options;

  public Option() {
    this.options = new ArrayList();
  }

  public void addOption(String text, String image, String link) {
    Map<String, Object> chip = new HashMap<>();
    chip.put("text", text);
    Map<String, Object> imageMap = new HashMap<>();
    Map<String, Object> imageSrc = new HashMap<>();
    imageSrc.put("rawUrl", image);
    imageMap.put("src", imageSrc);
    chip.put("image", imageMap);
    chip.put("link", link);
    this.options.add(chip);
  }

  public List getOptions() {
    return options;
  }
}
