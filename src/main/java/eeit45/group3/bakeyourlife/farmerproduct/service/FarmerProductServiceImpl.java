package eeit45.group3.bakeyourlife.farmerproduct.service;

import eeit45.group3.bakeyourlife.farmerproduct.dao.FarmerProductRepository;
import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class FarmerProductServiceImpl implements FarmerProductService {

  private FarmerProductRepository farmerProductRepository;

  public FarmerProductServiceImpl(FarmerProductRepository farmerProductRepository) {
    this.farmerProductRepository = farmerProductRepository;
  }

  @Override
  public List<FarmerProductBean> findAll() {
    return farmerProductRepository.findAll();
  }

  @Override
  public List<FarmerProductBean> findByFarmerId(Integer farmerId) {
    return farmerProductRepository.findByFarmerFarmerId(farmerId);
  }

  @Override
  public List<FarmerProductBean> findByFarmerFarmerIdOrderByLaunchedTimeDesc(Integer farmerId) {
    return farmerProductRepository.findByFarmerFarmerIdOrderByLaunchedTimeDesc(farmerId);
  }

  @Override
  public List<FarmerProductBean> findAllByOrderByLaunchedTimeDesc() {
    return farmerProductRepository.findAllByOrderByLaunchedTimeDesc();
  }

  @Override
  public List<FarmerProductBean> findByStateOrderByLaunchedTimeDesc(Integer state) {
    return farmerProductRepository.findByStateOrderByLaunchedTimeDesc(state);
  }

  @Override
  public List<FarmerProductBean> findByStateAndFarmerFarmerIdOrderByLaunchedTimeDesc(
      Integer farmerId) {
    return farmerProductRepository.findByStateAndFarmerFarmerIdOrderByLaunchedTimeDesc(0, farmerId);
  }

  @Override
  public List<FarmerProductBean> findByTypeAndStateOrderByLaunchedTimeDesc(String type) {
    return farmerProductRepository.findByTypeAndStateOrderByLaunchedTimeDesc(type, 0);
  }

  @Override
  public List<FarmerProductBean> findByTypeAndStateAndFarmerProductIdNotOrderByLaunchedTimeDesc(
      String type, Integer farmerProductId) {
    return farmerProductRepository.findByTypeAndStateAndFarmerProductIdNotOrderByLaunchedTimeDesc(
        type, 0, farmerProductId);
  }

  @Override
  public List<FarmerProductBean> findByTypeAndStateAndFarmerFarmerIdOrderByLaunchedTimeDesc(
      String type, Integer farmerId) {
    return farmerProductRepository.findByTypeAndStateAndFarmerFarmerIdOrderByLaunchedTimeDesc(
        type, 0, farmerId);
  }

  @Override
  public FarmerProductBean findByFarmerProductId(Integer farmerProductId) {
    return farmerProductRepository.findByFarmerProductId(farmerProductId);
  }

  @Override
  public Long count() {
    return farmerProductRepository.count();
  }

  @Override
  public Long countByFarmerId(Integer id) {
    return farmerProductRepository.countByFarmerFarmerId(id);
  }

  @Override
  public String saleAmountByFarmerId(Integer farmerId) {
    return farmerProductRepository.saleAmountByFarmerId(farmerId);
  }

  @Override
  public String saleAmount() {
    return farmerProductRepository.saleAmount();
  }

  @Override
  public Float avgStar() {
    return farmerProductRepository.avgStar();
  }

  @Override
  public Float avgStarByFarmerId(Integer farmerId) {
    return farmerProductRepository.avgStarByFarmerId(farmerId);
  }

  @Override
  public String topSaleItemByFarmerId(Integer farmerId) {
    return farmerProductRepository.topSaleItemByFarmerId(farmerId);
  }

  @Override
  public List<FarmerProductBean> topSix() {
    return farmerProductRepository.topSix();
  }

  @Override
  @Transactional
  public void insert(FarmerProductBean farmerProductBean) {
    farmerProductRepository.save(farmerProductBean);
  }

  @Override
  @Transactional
  public void update(FarmerProductBean farmerProductBean) {
    FarmerProductBean farmerProductBeanDb =
        farmerProductRepository.findByFarmerProductId(farmerProductBean.getFarmerProductId());
    if (farmerProductBeanDb == null) {
      throw new RuntimeException("沒有找到要更新的商品");
    }
    farmerProductRepository.save(farmerProductBean);
  }

  @Override
  @Transactional
  public void delete(Integer farmerProductId) {
    farmerProductRepository.deleteById(farmerProductId);
  }
}
