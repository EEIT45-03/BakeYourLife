package eeit45.group3.bakeyourlife.rental.dao;


import java.util.Date;
import java.util.List;


import eeit45.group3.bakeyourlife.rental.model.Rental;
import eeit45.group3.bakeyourlife.rental.model.Venue;
import eeit45.group3.bakeyourlife.rental.model.Tackle;
import eeit45.group3.bakeyourlife.rental.model.TackleList;
import eeit45.group3.bakeyourlife.rental.model.VenueList;
import eeit45.group3.bakeyourlife.user.model.User;



public interface RentalDAO {

/*租借單 DAO
----------------------------------------------------------------*/

	//查詢全部的租借單
	public List<Rental> findAllByRental();

	//依租借單ID查詢租借單
	public Rental findByRentalId(Integer rentalId);

	//新增租借單
	public boolean createRental(Rental rental);


	//更新租借單
	public boolean updateRental(Rental rental);

	//刪除租借單
	public boolean deleteRental(Integer rentalId);


/*場地租借清單 DAO
	----------------------------------------------------------------*/

	//查詢全部的場地租借清單
	public List<VenueList> findAllByVenueList();

	//依清單ID查詢場地租借清單
	public VenueList findByVenueListId(Integer venueListId);

	//依租借單ID查詢場地租借清單
	public List<VenueList> findVenueListByFK_RentalId(Integer FK_RentalId);

	//依租借時間查詢場地
	public Long findDateBetweenByFK_VenueId(Integer FK_venueId, Date lendTime, Date returnTime);

	//新增場地租借清單
	public boolean createVenueList(VenueList venueList);

	//更新場地租借清單
	public boolean updateVenueList(VenueList venueList);

	//刪除場地租借清單
	public boolean deleteVenueList(Integer venueListId);


/*教室 DAO
	----------------------------------------------------------------*/

	//查詢全部的教室
	public List<Venue>  findAllByVenue();

	//依教室ID查詢教室
	public Venue findByVenueId(Integer venueId);

	//依教室名稱查詢教室
	public Venue findByVenueName(String venueName);

	//新增教室
	public boolean createVenue(Venue venue);

	//更新教室
	public boolean updateVenue(Venue venue);

	//刪除教室
	public boolean deleteVenue(Integer venueId);


/*器具租借清單 DAO
	----------------------------------------------------------------*/

	//查詢全部的器具租借清單
	public List<TackleList> findAllByTackleList();

	//依清單ID查詢器具租借清單
	public TackleList findByTackleListId(Integer tackleListId);

	//依租借單ID查詢器具租借清單
	public List<TackleList> findTackleListByFK_RentalId(Integer FK_RentalId);

	//依租借時間查詢器具
	public Long findDateBetweenByFK_TackleId(Integer FK_tackleId, Date lendTime, Date returnTime);

	//新增器具租借清單
	public boolean createTackleList(TackleList tackleList);

	//更新器具租借清單
	public boolean updateTackleList(TackleList tackleList);

	//刪除器具租借清單
	public boolean deleteTackleList(Integer tackleListId);

	/*器具 DAO
	----------------------------------------------------------------*/

	//查詢全部的器具
	public List<Tackle>  findAllByTackle();

	//依教室ID查詢器具
	public Tackle findByTackleId(Integer tackleId);

	//依器具名稱查詢器具
	public Tackle findByTackleName(String tackleName);

	//新增器具
	public boolean createTackle(Tackle tackle);

	//更新器具
	public boolean updateTackle(Tackle tackle);

	//刪除器具
	public boolean deleteTackle(Integer tackleId);




	/*會員 DAO
	----------------------------------------------------------------*/

	//查詢全部的會員
	public List<User> findAllByUser();

	//依Id搜尋查詢會員
	public User findByUserId(Integer userId);





//	public Date stringToDate(String data);
//	public Date stringToDate(String date ,String time);
//	public java.sql.Date DateUtilToSql(Date date);



}