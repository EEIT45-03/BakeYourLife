package eeit45.group3.bakeyourlife.rental.service;

import java.util.Date;
import java.util.List;

import eeit45.group3.bakeyourlife.rental.dto.RentalRequest;
import eeit45.group3.bakeyourlife.rental.dto.TackleListRequest;
import eeit45.group3.bakeyourlife.rental.dto.VenueListRequest;
import eeit45.group3.bakeyourlife.rental.model.*;
import eeit45.group3.bakeyourlife.rental.model.Venue;
import eeit45.group3.bakeyourlife.user.model.User;



public interface RentalService {
	/*租借單 DAO
	----------------------------------------------------------------*/	
		
		//查詢全部的租借單
		public List<Rental> findAllRental();
		
		//依租借單ID查詢租借單
		public Rental findByRentalId(Integer rentalId);

		//依租借單類型查詢租借單
		public List<Rental> findAllByType(String type);

		public List<Rental> findAllByDateBetween(String lDate, String eDate);

		
		//新增租借單
		public Rental createRental(Rental rental);
		public Rental createRental(RentalRequest rentalRequest);
		
		//更新租借單
		public Rental updateRental(Rental rental);
		
		//刪除租借單
		public void deleteRental(Integer rentalId);
		
		
	/*場地租借清單 DAO
		----------------------------------------------------------------*/		
		
		//查詢全部的場地租借清單
		public List<VenueList> findAllVenueList();
			
		//依清單ID查詢場地租借清單
		public VenueList findByVenueListId(Integer venueListId);
		
		//依租借單ID查詢場地租借清單
		public List<VenueList> findVenueListByFK_RentalId(Integer FK_rentalId);
		
		//依租借時間查詢場地
//		public Long findDateBetweenByFK_VenueId(Integer FK_venueId, Date lendTime, Date returnTime);
		
		//新增場地租借清單
		public VenueList createVenueList(VenueList venueList);
		public VenueList createVenueList(Integer rentalId, VenueListRequest venueListRequest);
		
		//更新場地租借清單
		public VenueList updateVenueList(VenueList venueList);
			
		//刪除場地租借清單
		public void deleteVenueList(Integer venueListId);
		
		
	/*教室 DAO
		----------------------------------------------------------------*/		
		
		//查詢全部的教室
		public List<Venue>  findAllVenue();

		//查詢全部的教室名稱
		public List<String> findAllVenueName();
		
		//依教室ID查詢教室
		public Venue findByVenueId(Integer venueId);
		
		//依教室名稱查詢教室	
		public Venue findByVenueName(String venueName);
		
		//新增教室	
		public Venue createVenue(Venue venue);
//		public boolean createVenue(VenueRequest venueRequest);
		
		//更新教室	
		public Venue updateVenue(Venue venue);
		
		//刪除教室	
		public void deleteVenue(Integer venueId);

		
		/*器具租借清單 DAO
		----------------------------------------------------------------*/		
		
		//查詢全部的器具租借清單
		public List<TackleList> findAllTackleList();
			
		//依清單ID查詢器具租借清單
		public TackleList findByTackleListId(Integer tackleListId);
		
		//依租借單ID查詢器具租借清單
		public List<TackleList> findTackleListByFK_RentalId(Integer FK_RentalId);
		
		//依租借時間查詢器具
//		public Long findDateBetweenByFK_TackleId(Integer FK_tackleId, Date lendTime, Date returnTime);
		
		//新增器具租借清單
		public TackleList createTackleList(TackleList tackleList);
		public TackleList createTackleList(Integer rentalId, TackleListRequest tackleListRequest);
		
		//更新器具租借清單
		public TackleList updateTackleList(TackleList tackleList);
			
		//刪除器具租借清單
		public void deleteTackleList(Integer tackleListId);
		
		
		/*器具 DAO
		----------------------------------------------------------------*/		
		
		//查詢全部的器具
		public List<Tackle>  findAllTackle();
		
		//依器具ID查詢器具
		public Tackle findByTackleId(Integer tackleId);
		
		//依器具名稱查詢器具
		public Tackle findByTackleName(String tackleName);
		
		//新增器具	
		public Tackle createTackle(Tackle tackle);
		
		//更新器具	
		public Tackle updateTackle(Tackle tackle);
		
		//刪除器具
		public void deleteTackle(Integer tackleId);
		
		
		
		
		/*會員 DAO
		----------------------------------------------------------------*/		
		
		//查詢全部的會員
//		public List<User> findAllByUser();
		
		//依Id搜尋查詢會員
//		public User findByUserId(Integer userId);
}
