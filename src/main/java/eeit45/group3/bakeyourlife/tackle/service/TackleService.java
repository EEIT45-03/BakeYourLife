package eeit45.group3.bakeyourlife.tackle.service;

import eeit45.group3.bakeyourlife.tackle.dto.TackleRequest;
import eeit45.group3.bakeyourlife.tackle.model.Tackle;
import eeit45.group3.bakeyourlife.tackle.model.TackleSort;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface TackleService {

  // 查詢全部的器具
  public List<Tackle> findAllTackle();
  // 查詢全部的器具名稱
  public List<String> findAllTackleName();

  // 依種類查詢全部的器具
  public List<Tackle> findAllByTackleNameAndTackleSort(String tackleName, String sort);

  // 依器具名稱與種類查詢全部的器具
  public List<Tackle> findAllByTackleSort(String sort);

  // 依器具ID查詢器具
  public Tackle findByTackleId(Integer tackleId);

  // 依器具名稱查詢器具
  public Tackle findByTackleName(String tackleName);

  // 新增器具
  public Tackle createTackle(Tackle tackle);

  public Tackle createTackle(TackleRequest tackle);

  // 更新器具
  public Tackle updateTackle(Tackle tackle);

  // 刪除器具
  public void deleteTackle(Integer tackleId);

  // 查詢全部的器具類別
  public List<TackleSort> findAllTackleSort();

  // 依ID查詢全部的器具類別
  public TackleSort findByTackleSortId(Integer tackleSortId);

  // 新增器具類別
  public TackleSort createTackleSort(TackleSort tackleSort);

  // 更新器具類別
  public TackleSort updateTackleSort(TackleSort tackleSort);

  // 刪除器具類別
  public void deleteTackleSort(Integer tackleSortId);

  // 依種類查詢全部的場地
  public List<Tackle> findAllByTackleSort(Integer tackleSortId);

  public boolean createTacklePicList(String tackleName, MultipartFile[] file);
}
