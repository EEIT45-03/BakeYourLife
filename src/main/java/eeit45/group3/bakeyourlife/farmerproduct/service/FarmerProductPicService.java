package eeit45.group3.bakeyourlife.farmerproduct.service;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductPic;

import java.util.List;

public interface FarmerProductPicService {

    FarmerProductPic findByPicId(Integer picId);

    List<FarmerProductPic> findAllByFarmerProductBean_FarmerProductId(Integer farmerProductId);

    void insertAll(List<FarmerProductPic> farmerProductPicList);

    void saveOrUpdate(FarmerProductPic farmerProductPic);

    void delete(Integer picId);

}
