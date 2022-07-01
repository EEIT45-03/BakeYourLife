package eeit45.group3.bakeyourlife.farmerproduct.service;


import eeit45.group3.bakeyourlife.farmerproduct.dao.FarmerProductPicRepository;
import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductPic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class FarmerProductPicServiceImpl implements FarmerProductPicService {

    private FarmerProductPicRepository farmerProductPicRepository;

    public FarmerProductPicServiceImpl(FarmerProductPicRepository farmerProductPicRepository) {
        this.farmerProductPicRepository = farmerProductPicRepository;
    }

    @Override
    public FarmerProductPic findByPicId(Integer picId) {
        return farmerProductPicRepository.findByPicId(picId);
    }

    @Override
    public List<FarmerProductPic> findAllByFarmerProductBean_FarmerProductId(Integer farmerProductId) {
        return farmerProductPicRepository.findAllByFarmerProductBean_FarmerProductId(farmerProductId);
    }

    @Override
    @Transactional
    public void insertAll(List<FarmerProductPic> farmerProductPicList) {
        farmerProductPicRepository.saveAll(farmerProductPicList);
    }

    @Override
    @Transactional
    public void saveOrUpdate(FarmerProductPic farmerProductPic) {
        farmerProductPicRepository.save(farmerProductPic);
    }

    @Override
    @Transactional
    public void delete(Integer picId) {
        farmerProductPicRepository.deleteById(picId);
    }
}
