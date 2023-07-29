package eeit45.group3.bakeyourlife.utils;

public class Image {
  // Imgur 圖片ID
  private String id;
  // Imgur 圖片URL
  private String link;
  // Imgur 刪除hash
  private String deletehash;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getDeletehash() {
    return deletehash;
  }

  public void setDeletehash(String deletehash) {
    this.deletehash = deletehash;
  }

  @Override
  public String toString() {
    return "Image{"
        + "id='"
        + id
        + '\''
        + ", link='"
        + link
        + '\''
        + ", deletehash='"
        + deletehash
        + '\''
        + '}';
  }
}
