package eeit45.group3.bakeyourlife.farmerproduct.service;

import eeit45.group3.bakeyourlife.farmerproduct.dao.FarmerProductRepository;
import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public FarmerProductBean findByFarmerProductId(Integer farmerProductId) {
        return farmerProductRepository.findByFarmerProductId(farmerProductId);
    }

    @Override
    @Transactional
    public void insert(FarmerProductBean farmerProductBean) {
        farmerProductRepository.save(farmerProductBean);

    }

    @Override
    @Transactional
    public void update(FarmerProductBean farmerProductBean) {
        FarmerProductBean farmerProductBeanDb = farmerProductRepository.findByFarmerProductId(farmerProductBean.getFarmerProductId());
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
