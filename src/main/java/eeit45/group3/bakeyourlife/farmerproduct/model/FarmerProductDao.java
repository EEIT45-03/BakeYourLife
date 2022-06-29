package eeit45.group3.bakeyourlife.farmerproduct.model;

import java.util.List;

public interface FarmerProductDao {

	// 查詢全部資料
	public List<FarmerProductBean> findAll();

	// 新增
	public void insert(FarmerProductBean farmerProductBean);

	// 修改
	public void update(FarmerProductBean farmerProductBean);

	// 刪除
	public void delete(Integer farmerProductId);

	// 取一筆資料
	public FarmerProductBean findById(Integer farmerProductId);

//	// 修改上下架狀態
//	public void updateState(FarmerProductBean farmerProductBean);

	// 修改申請狀態
//	public void updateApplyState(FarmerProductBean farmerProductBean);

	// 修改 不包含圖片
//	public void updateWitoutPic(FarmerProductBean farmerProductBean);

	// 狀態條件查詢
//	public List<FarmerProductBean> queryState(Integer sfProductState);

	// 條件查詢
//	public List<FarmerProductBean> query(Integer sfProductNo, String sfProductName);

}
