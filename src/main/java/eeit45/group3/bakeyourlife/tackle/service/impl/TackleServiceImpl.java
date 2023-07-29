package eeit45.group3.bakeyourlife.tackle.service.impl;

import static eeit45.group3.bakeyourlife.utils.ImgurService.updateByMultipartFile;

import eeit45.group3.bakeyourlife.tackle.dao.TacklePicListRepository;
import eeit45.group3.bakeyourlife.tackle.dao.TackleRepository;
import eeit45.group3.bakeyourlife.tackle.dao.TackleSortRepository;
import eeit45.group3.bakeyourlife.tackle.dto.TackleRequest;
import eeit45.group3.bakeyourlife.tackle.model.Tackle;
import eeit45.group3.bakeyourlife.tackle.model.TacklePicList;
import eeit45.group3.bakeyourlife.tackle.model.TackleSort;
import eeit45.group3.bakeyourlife.tackle.service.TackleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional(readOnly = true)
public class TackleServiceImpl implements TackleService {

  private TackleRepository tackleRepository;

  private TackleSortRepository tackleSortRepository;

  private TacklePicListRepository tacklePicListRepository;

  @Autowired
  public TackleServiceImpl(
      TackleRepository tackleRepository,
      TackleSortRepository tackleSortRepository,
      TacklePicListRepository tacklePicListRepository) {
    this.tackleRepository = tackleRepository;
    this.tackleSortRepository = tackleSortRepository;
    this.tacklePicListRepository = tacklePicListRepository;
  }

  // 查詢全部的器具
  @Override
  public List<Tackle> findAllTackle() {
    return tackleRepository.findAll();
  }

  // 查詢全部的器具名稱
  @Override
  public List<String> findAllTackleName() {
    return tackleRepository.findAllTackleName();
  }

  // 依種類查詢全部的器具
  public List<Tackle> findAllByTackleSort(String sort) {
    TackleSort sortDb = tackleSortRepository.findBySort(sort);

    return tackleRepository.findByTackleSort(sortDb);
  }

  // 依種類查詢全部的器具
  public List<Tackle> findAllByTackleNameAndTackleSort(String tackleName, String sort) {
    TackleSort sortDb = tackleSortRepository.findBySort(sort);
    return tackleRepository.findByTackleNameAndTackleSort(tackleName, sortDb);
  }

  // 依器具ID查詢器具
  @Override
  public Tackle findByTackleId(Integer tackleId) {
    return tackleRepository.findById(tackleId).orElse(null);
  }

  // 依器具名稱查詢器具
  @Override
  public Tackle findByTackleName(String tackleName) {
    return tackleRepository.findByTackleName(tackleName);
  }

  // 新增器具
  @Override
  @Transactional
  public Tackle createTackle(Tackle tackle) {
    TackleSort sort =
        tackleSortRepository.findById(tackle.getTackleSort().getTackleSortId()).orElse(null);
    tackle.setTackleSort(sort);
    return tackleRepository.save(tackle);
  }

  @Override
  @Transactional
  public Tackle createTackle(TackleRequest tackleRequest) {
    //        Tackle tackle = new Tackle();
    //        if(tackleRequest.getTackleName()!=null){
    //            tackle.setTackleName(tackleRequest.getTackleName());
    //        }
    //        if(tackleRequest.getSpecification()!=null){
    //            tackle.setSpecification(tackleRequest.getSpecification());
    //        }
    //        if(tackleRequest.getDayPrice()!=null){
    //            tackle.setDayPrice(tackleRequest.getDayPrice());
    //        }
    //        if(tackleRequest.getDamages()!=null){
    //            tackle.setDamages(tackleRequest.getDamages());
    //        }
    //        if(tackleRequest.getMax()!=null){
    //            tackle.setMax(tackleRequest.getMax());
    //        }
    //        if(tackleRequest.getSortId()!=null){
    //            TackleSort tackleSort =
    // tackleSortRepository.findById(tackleRequest.getSortId()).orElse(null);
    //            tackle.setTackleSort(tackleSort);
    //        }
    //        if(tackleRequest.getNotes()!=null){
    //            tackle.setNotes(tackleRequest.getNotes());
    //        }
    //        return tackleRepository.save(tackle);
    return null;
  }

  // 更新器具
  @Override
  @Transactional
  public Tackle updateTackle(Tackle tackle) {
    TackleSort sort =
        tackleSortRepository.findById(tackle.getTackleSort().getTackleSortId()).orElse(null);
    tackle.setTackleSort(sort);

    return tackleRepository.save(tackle);
  }

  // 刪除器具
  @Override
  @Transactional
  public void deleteTackle(Integer tackleId) {
    tackleRepository.deleteById(tackleId);
  }

  // 查詢全部的器具類別
  @Override
  public List<TackleSort> findAllTackleSort() {
    return tackleSortRepository.findAll();
  }

  // 依ID查詢全部的器具類別
  @Override
  public TackleSort findByTackleSortId(Integer tackleSortId) {
    return tackleSortRepository.findById(tackleSortId).orElse(null);
  }

  // 新增器具類別
  @Override
  public TackleSort createTackleSort(TackleSort tackleSort) {
    return tackleSortRepository.save(tackleSort);
  }

  // 更新器具類別
  @Override
  public TackleSort updateTackleSort(TackleSort tackleSort) {
    return tackleSortRepository.save(tackleSort);
  }

  // 刪除器具類別
  @Override
  public void deleteTackleSort(Integer tackleSortId) {
    tackleSortRepository.deleteById(tackleSortId);
  }

  @Override
  public List<Tackle> findAllByTackleSort(Integer tackleSortId) {
    TackleSort tackleSort = tackleSortRepository.findById(tackleSortId).orElse(null);
    return tackleRepository.findAllByTackleSort(tackleSort);
  }

  public boolean createTacklePicList(String tackleName, MultipartFile[] file) {
    if (file != null) {
      Tackle tackle = findByTackleName(tackleName);

      for (int i = 0; i < file.length; i++) {
        TacklePicList tacklePicList = new TacklePicList();
        tacklePicList.setTackle(tackle);
        tacklePicList.setPicture(updateByMultipartFile(file[i]).getLink());
        tacklePicListRepository.save(tacklePicList);
      }
      return true;
    }
    return false;
  }
}
