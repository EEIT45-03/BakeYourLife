package eeit45.group3.bakeyourlife.rental.service;

import eeit45.group3.bakeyourlife.rental.dto.TackleListRequest;
import eeit45.group3.bakeyourlife.rental.dto.VenueListRequest;
import eeit45.group3.bakeyourlife.rental.model.ProduceNo;
import eeit45.group3.bakeyourlife.rental.model.Rental;
import eeit45.group3.bakeyourlife.rental.model.TackleList;
import eeit45.group3.bakeyourlife.rental.model.VenueList;
import eeit45.group3.bakeyourlife.rental.utils.AvailableQuantity;
import eeit45.group3.bakeyourlife.user.model.User;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;


public interface RentalService {
	/*租借單 DAO
	----------------------------------------------------------------*/

	//查詢全部的租借單
	public List<Rental> findAllRental();

	//依租借單ID查詢租借單
	public Rental findByRentalId(Integer rentalId);

	//依租借單類型查詢租借單
	public List<Rental> findAllByType(String type);

	//依租借單狀態查詢租借單
	public List<Rental> findAllByState(String state);

	//依租借單編號查詢租借單
	public List<Rental> findAllByRentalNoStartingWith(String rentalNo);

	//依會員查詢租借單
	public List<Rental> findAllByUser(Integer userId);
	//依會員與租借單編號查詢租借單
	public List<Rental> findAllByUserAndRentalNoStartingWith(Integer userId,String RentalNo);
	//依租借類型與租借單編號查詢租借單
	public List<Rental> findAllByTypeAndRentalNoStartingWith(String listType,String RentalNo);
	//依會員與租借類型查詢租借單
	public List<Rental> findAllByUserAndType(Integer userId,String listType);
	//依租借編號與會員與租借類型查詢租借單
	List<Rental> findAllByUserAndTypeAndRentalNoStartingWith(Integer userId,String listType, String rentalNo);


	//依租借單編號查詢租借單
	public Rental findByRentalNo(String rentalNo);


	//新增租借單
	public Rental createRental(Rental rental);
//	public Rental createRental(RentalRequest rentalRequest);

	//更新租借單
	public Rental updateRental(Rental rental);
//	public Rental updateRental(Integer rentalId);

//	public Rental updateRental(Integer id, Rental rental);

	public void deleteRental(Integer rentalId);

	//建請租借單請求資料
	public Rental createRentalNoRequest();

	public Rental CheckUserRental(Integer userId, String listType);


	public Rental updateRentalPic(Rental rental);

	/*場地租借清單 DAO
		----------------------------------------------------------------*/

	//查詢全部的場地租借清單
	public List<VenueList> findAllVenueList();

	//依清單ID查詢場地租借清單
	public VenueList findByVenueListId(Integer venueListId);

	//依租借單ID查詢場地租借清單
	public List<VenueList> findVenueListByFK_RentalId(Integer FK_rentalId);

	//查詢租借單場地租借總金額
	public Long findVenueListPriceSumByRental(Rental rental);

	//查詢某時間的場地使用狀況
	public List<AvailableQuantity> getVenueSelect(String name, Date date);

	//依租借單查詢場地清單

	//依租借時間查詢場地
//	public Long findDateBetweenByFK_VenueId(Integer FK_venueId, Date lendTime, Date returnTime);

	//新增場地租借清單
	public VenueList createVenueList(VenueList venueList);

	public VenueList createVenueList(VenueListRequest venueListRequest, Principal principal) throws ParseException;

//	public VenueList createVenueList(Integer fk_rentalId, VenueList venueList);
	//更新場地租借清單
	public VenueList updateVenueList(VenueList venueList);

	//刪除場地租借清單
	public void deleteVenueList(Integer venueListId);

	//建請場地清單請求資料
	public VenueList createVenueListNoRequest(Rental rental);

	public boolean checkVenueListRequest(VenueListRequest venueListRequest);



	/*教室 DAO
		----------------------------------------------------------------*/




	/*器具租借清單 DAO
		----------------------------------------------------------------*/

	//查詢全部的器具租借清單
	public List<TackleList> findAllTackleList();

	//依清單ID查詢器具租借清單
	public TackleList findByTackleListId(Integer tackleListId);

	//依租借單ID查詢器具租借清單
	public List<TackleList> findTackleListByFK_RentalId(Integer FK_RentalId);

	//查詢租借單器具租借總金額
//	public Long findTackleListPriceSumByRental(Rental rental);

	//依租借時間查詢器具
//	public Long findDateBetweenByFK_TackleId(Integer FK_tackleId, Date lendTime, Date returnTime);

	//新增器具租借清單
	public TackleList createTackleList(TackleList tackleList);
	public TackleList createTackleList(TackleListRequest tackleListRequest);


	//更新器具租借清單
	public TackleList updateTackleList(TackleList tackleList);

	//刪除器具租借清單
	public void deleteTackleList(Integer tackleListId);

	//建立器具清單請求資料
	public TackleListRequest createTackleListNoRequest(Rental rental);

	/*器具 DAO
		----------------------------------------------------------------*/




	/*自動產生編號 DAO
	----------------------------------------------------------------*/

	//查詢全部產生編號
	public List<ProduceNo> findAllByProduceNo(ProduceNo produceNo);

	//依table查詢產生編號
	public ProduceNo findByTable(String table);

	//新增產生編號
	public ProduceNo createProduceNo(ProduceNo produceNo);

	//更新編號
	public ProduceNo updateProduceNo(ProduceNo produceNo);
	public ProduceNo updateProduceNo(String no);

	//刪除編號
	public void deleteProduceNo(Integer id);


	public void sendRentalMail(Rental rental) throws UnsupportedEncodingException, MessagingException;

}
