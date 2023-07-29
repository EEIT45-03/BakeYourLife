package eeit45.group3.bakeyourlife.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

public class ImgurService {

  private static final String clientId = "de8285861c5e235";

  // use RestTemplate update Imgur
  private static final RestTemplate restTemplate = new RestTemplate();
  // json object mapping
  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static Image updateByMultipartFile(MultipartFile multipartFile) {
    String url = "https://api.imgur.com/3/image";
    String response = null;
    Image image = null;
    try {
      HttpHeaders headers = new HttpHeaders();
      headers.add("Authorization", "Client-ID " + clientId);
      HttpEntity<Object> entity = new HttpEntity<>(multipartFile.getBytes(), headers);
      response = restTemplate.postForObject(url, entity, String.class);
      Map map = objectMapper.readValue(response, Map.class);
      Map data = (Map) map.get("data");
      image = new Image();
      image.setId((String) data.get("id"));
      image.setLink((String) data.get("link"));
      image.setDeletehash((String) data.get("deletehash"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return image;
  }

  public static Image updateByBase64(String base64) {
    String url = "https://api.imgur.com/3/image";
    String response = null;
    Image image = null;
    try {
      HttpHeaders headers = new HttpHeaders();
      headers.add("Authorization", "Client-ID " + clientId);
      HttpEntity<Object> entity = new HttpEntity<>(base64, headers);
      response = restTemplate.postForObject(url, entity, String.class);
      Map map = objectMapper.readValue(response, Map.class);
      Map data = (Map) map.get("data");
      image = new Image();
      image.setId((String) data.get("id"));
      image.setLink((String) data.get("link"));
      image.setDeletehash((String) data.get("deletehash"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return image;
  }

  // 刪除圖片
  public static void deleteImgur(String deletehash) {
    String url = "https://api.imgur.com/3/image/" + deletehash;
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Client-ID " + clientId);
    HttpEntity<Object> entity = new HttpEntity<>(headers);
    restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
  }
}
