package eeit45.group3.bakeyourlife.farmerproduct.service;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductPic;

import java.util.List;

public interface FarmerProductPicService {


    void insertAll(List<FarmerProductPic> farmerProductPicList);


    void deleteByFarmerProductId(Integer farmerProductId);


}
