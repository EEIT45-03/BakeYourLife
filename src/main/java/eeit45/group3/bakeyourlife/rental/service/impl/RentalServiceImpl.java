package eeit45.group3.bakeyourlife.rental.service.impl;

import eeit45.group3.bakeyourlife.rental.dao.ProduceNoRepository;
import eeit45.group3.bakeyourlife.rental.dao.RentalRepository;
import eeit45.group3.bakeyourlife.rental.dao.TackleListRepository;
import eeit45.group3.bakeyourlife.rental.dao.VenueListRepository;
import eeit45.group3.bakeyourlife.rental.model.ProduceNo;
import eeit45.group3.bakeyourlife.rental.model.Rental;
import eeit45.group3.bakeyourlife.rental.model.TackleList;
import eeit45.group3.bakeyourlife.rental.model.VenueList;
import eeit45.group3.bakeyourlife.rental.service.RentalService;
import eeit45.group3.bakeyourlife.tackle.model.Tackle;
import eeit45.group3.bakeyourlife.tackle.service.TackleService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import eeit45.group3.bakeyourlife.venue.model.Venue;
import eeit45.group3.bakeyourlife.venue.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service("rentalService")
@Transactional(readOnly = true)
public class RentalServiceImpl implements RentalService{

	UserService userService;

	TackleService tackleService;

	VenueService venueService;

	RentalRepository rentalRepository;

	VenueListRepository venueListRepository;

	TackleListRepository tackleListRepository;

	ProduceNoRepository produceNoRepository;

	@Autowired
	public RentalServiceImpl(UserService userService, TackleService tackleService, VenueService venueService, RentalRepository rentalRepository, VenueListRepository venueListRepository, TackleListRepository tackleListRepository, ProduceNoRepository produceNoRepository) {
		this.userService = userService;
		this.tackleService = tackleService;
		this.venueService = venueService;
		this.rentalRepository = rentalRepository;
		this.venueListRepository = venueListRepository;
		this.tackleListRepository = tackleListRepository;
		this.produceNoRepository = produceNoRepository;
	}





/*租借單 DAO
	----------------------------------------------------------------*/	
	
	//查詢全部的租借單
	@Override
	@Transactional
	public List<Rental> findAllRental() {
		return rentalRepository.findAll();
	}

	//依租借單ID查詢租借單
	@Override
	public Rental findByRentalId(Integer rentalId) {
		return rentalRepository.findById(rentalId).orElse(null);
	}

	//依租借單類型查詢租借單
	@Override
	public List<Rental> findAllByType(String listType) {
		return rentalRepository.findAllByType(listType);
	}

	//依租借單編號查詢租借單
	@Override
	public List<Rental> findAllByRentalNoStartingWith(String rentalNo) {
		return rentalRepository.findAllByRentalNoStartingWith(rentalNo);
	}

	//依會員查詢租借單
	@Override
	public List<Rental> findAllByUser(Integer userId) {
		User userBean = userService.findByUserId(userId);
		return rentalRepository.findAllByUser(userBean);
	}

	//依會員與租借單編號查詢租借單
	@Override
	public List<Rental> findAllByUserAndRentalNoStartingWith(Integer userId, String RentalNo) {
		User userBean = userService.findByUserId(userId);
		return rentalRepository.findAllByUserAndRentalNoStartingWith(userBean,RentalNo);
	}
	//依租借類型與租借單編號查詢租借單
	@Override
	public List<Rental> findAllByTypeAndRentalNoStartingWith(String listType, String RentalNo) {
		return rentalRepository.findAllByTypeAndRentalNoStartingWith(listType,RentalNo);
	}
	//依會員與租借類型查詢租借單
	@Override
	public List<Rental> findAllByUserAndType(Integer userId, String listType) {
		User userBean = userService.findByUserId(userId);
		return rentalRepository.findAllByUserAndType(userBean, listType);
	}
	//依租借編號與會員與租借類型查詢租借單
	@Override
	public List<Rental> findAllByUserAndTypeAndRentalNoStartingWith(Integer userId, String listType, String rentalNo) {
		User userBean = userService.findByUserId(userId);
		return rentalRepository.findAllByUserAndTypeAndRentalNoStartingWith(userBean, listType, rentalNo);
	}


	//依租借單編號查詢租借單
	public Rental findByRentalNo(String rentalNo){
		return rentalRepository.findByRentalNo(rentalNo);
	}

	//新增租借單
	@Override
	@Transactional
	public Rental createRental(Rental rental) {
		if(rental.getUser().getUserId()!=null){
			User user = userService.findByUserId(rental.getUser().getUserId());
			rental.setUser(user);
		}
		rental.setRentalDate(new Date());
		return rentalRepository.save(rental);
	}
	
	//更新租借單
	@Override
	@Transactional
	public Rental updateRental(Rental rental) {
		return rentalRepository.save(rental);
	}

	public Rental updateRental(Integer rentalId){
		Rental rental = findByRentalId(rentalId);
		if(rental != null) {
			Long sum = findTackleListPriceSumByRental(rental);
			if (sum != null) {
				rental.setTotal(sum.intValue());
			} else {
				rental.setTotal(0);
			}
		}
		return updateRental(rental);
	}
	//刪除租借單
	@Override
	@Transactional
	public void deleteRental(Integer rentalId) {
		rentalRepository.deleteById(rentalId);
	}


	//建立租借單請求資料
	@Override
	public Rental createRentalNoRequest() {
		ProduceNo produceNo = produceNoRepository.findByName("rental");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String newDate = sdf.format(new Date());

		if(produceNo == null ){
			produceNo = new ProduceNo("rental",newDate,1);
		} else {
			String date = produceNo.getDate();


			if(date.equals(newDate)){
				int number = produceNo.getNum() + 1;
				produceNo.setNum(number);
			} else{
				produceNo.setDate(newDate);
				produceNo.setNum(1);
			}

		}

		String rentalNo = produceNo.getDate() + String.format("%07d", produceNo.getNum());

		Rental rental = new Rental();
		rental.setRentalNo(rentalNo);
		rental.setTotal(0);
		return rental;
	}


	/*場地租借清單 DAO
	----------------------------------------------------------------*/		
	
	//查詢全部的場地租借清單
	@Override
	public List<VenueList> findAllVenueList() {
		return venueListRepository.findAll();
	}

	//依清單ID查詢場地租借清單
	@Override
	public VenueList findByVenueListId(Integer venueListId) {
		return venueListRepository.findById(venueListId).orElse(null);
	}

	//依租借單ID查詢場地租借清單
	@Override
	public List<VenueList> findVenueListByFK_RentalId(Integer FK_rentalId) {
		Rental rental = rentalRepository.findById(FK_rentalId).orElse(null);
		return venueListRepository.findAllByRental(rental);
	}

	//查詢租借單場地租借總金額
	@Override
	public Long findVenueListPriceSumByRental(Rental rental) {
		return venueListRepository.findPriceSumByRental(rental);
	}


	//依租借時間查詢場地
//	@Override
//	public Long findDateBetweenByFK_VenueId(Integer FK_venueId, Date lendTime, Date returnTime) {
//		Long sum = null;
//			sum = rentalDao.findDateBetweenByFK_VenueId(FK_venueId, lendTime, returnTime);
//		return sum;
//	}

	//新增場地租借清單
	@Override
	@Transactional
	public VenueList createVenueList(VenueList venueList) {
		return venueListRepository.save(venueList);
	}

	@Override
	public VenueList createVenueList(Integer fk_rentalId, VenueList venueList) {
		if(fk_rentalId != null){
			Rental rental = findByRentalId(fk_rentalId);
			venueList.setRental(rental);
		}
		if(venueList.getVenue().getVenueId() != null){
			Venue venue = venueService.findByVenueId(venueList.getVenue().getVenueId());
			venueList.setVenue(venue);
		}
		return venueListRepository.save(venueList);
	}


	//更新場地租借清單
	@Override
	@Transactional
	public VenueList updateVenueList(VenueList venueList) {
		return venueListRepository.save(venueList);
	}

	public VenueList updateVenueList(Integer venueListId, VenueList venueList) {

		VenueList venueListDb = findByVenueListId(venueListId);

		if(venueList.getRental().getRentalNo()!=null){
			Rental rental = findByRentalNo(venueList.getRental().getRentalNo());
			venueListDb.setRental(rental);
		}
		if(venueList.getVenue().getVenueId()!=null){
			Venue venue = venueService.findByVenueId(venueList.getVenue().getVenueId());
			venueListDb.setVenue(venue);
		}
//		if(venueList.getLendTime()!=null){
//			venueListDb.setLendTime(venueList.getLendTime());
//		}
//		if(venueList.getEndTime()!=null){
//			venueListDb.setEndTime(venueList.getEndTime());
//		}
		if(venueList.getIngredients()!=null){
			venueListDb.setIngredients(venueList.getIngredients());
		}
		if(venueList.getPerson()!=null){
			venueListDb.setPrice(venueList.getPrice());
		}
		if(venueList.getPrice()!=null){
			venueListDb.setPrice(venueList.getPrice());
		}
		return venueListRepository.save(venueList);
	}

	//刪除場地租借清單
	@Override
	@Transactional
	public void deleteVenueList(Integer venueListId) {
		venueListRepository.deleteById(venueListId);
	}

	@Override
	public VenueList createVenueListNoRequest(Rental rental) {

		ProduceNo produceNo = produceNoRepository.findByName("VenueList");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String newDate = sdf.format(new Date());

		if(produceNo == null ){
			produceNo = new ProduceNo("VenueList",newDate,1);
		} else {

			String date = produceNo.getDate();

			if(date.equals(newDate)){
				int number = produceNo.getNum() + 1;
				produceNo.setNum(number);
			} else{
				produceNo.setDate(newDate);
				produceNo.setNum(1);
			}
		}
		String no =  "V" + produceNo.getDate() + String.format("%03d", produceNo.getNum());

		VenueList venueList = new VenueList();
		venueList.setVenueListNo(no);
		venueList.setPrice(0);
		venueList.setRental(rental);
		return venueList;
	}

	/*教室 DAO
	----------------------------------------------------------------*/		
	

	
	
	/*器具租借清單 DAO
	----------------------------------------------------------------*/		
	
	//查詢全部的器具租借清單
	@Override
	public List<TackleList> findAllTackleList() {
		return tackleListRepository.findAll();
	}

	//依清單ID查詢器具租借清單
	@Override
	public TackleList findByTackleListId(Integer tackleListId) {
		return tackleListRepository.findById(tackleListId).orElse(null);
	}

	//依租借單ID查詢器具租借清單
	@Override
	public List<TackleList> findTackleListByFK_RentalId(Integer FK_RentalId) {
		Rental rental = rentalRepository.findById(FK_RentalId).orElse(null);
		return tackleListRepository.findAllByRental(rental);
	}

	//查詢租借單器具租借總金額
	@Override
	public Long findTackleListPriceSumByRental(Rental rental) {
		return tackleListRepository.findPriceSumByRental(rental);
	}

	//依租借時間查詢器具
//	@Override
//	public Long findDateBetweenByFK_TackleId(Integer FK_tackleId, Date lendTime, Date returnTime) {
//		Long sum = null;
//		sum = rentalDao.findDateBetweenByFK_TackleId(FK_tackleId, lendTime, returnTime);
//		return sum;
//	}

	//新增器具租借清單
	@Override
	@Transactional
	public TackleList createTackleList(TackleList tackleList) {
		return tackleListRepository.save(tackleList);
	}

	@Override
	@Transactional
	public TackleList createTackleList(Integer rentalId, TackleList tackleList) {
		Rental rental = null;
		if(rentalId != null) {
			rental = findByRentalId(rentalId);
			tackleList.setRental(rental);
		}
		if(tackleList.getTackle().getTackleId() != null){
			Tackle tackle = tackleService.findByTackleId(tackleList.getTackle().getTackleId());
			tackleList.setTackle(tackle);
		}
			return tackleListRepository.save(tackleList);
	}
	
	//更新器具租借清單
	@Override
	@Transactional
	public TackleList updateTackleList(TackleList tackleList) {
		return tackleListRepository.save(tackleList);
	}

	//刪除場地租借清單
	@Override
	@Transactional
	public void deleteTackleList(Integer tackleListId) {
		tackleListRepository.deleteById(tackleListId);
	}

	@Override
	public TackleList createTackleListNoRequest(Rental rental) {

		ProduceNo produceNo = produceNoRepository.findByName("TackleList");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String newDate = sdf.format(new Date());

		if(produceNo == null ){
			produceNo = new ProduceNo("TackleList",newDate,1);
		} else {

			String date = produceNo.getDate();

			if(date.equals(newDate)){
				int number = produceNo.getNum() + 1;
				produceNo.setNum(number);
			} else{
				produceNo.setDate(newDate);
				produceNo.setNum(1);
			}
		}
		String no =  "T" + produceNo.getDate() + String.format("%03d", produceNo.getNum());

		TackleList tackleList = new TackleList();
		tackleList.setTackleListNo(no);
		tackleList.setPrice(0);
		tackleList.setRental(rental);
		return tackleList;

	}


	/*器具 DAO
	----------------------------------------------------------------*/		
	

	
	
	
	/*自動產生編號 DAO
	----------------------------------------------------------------*/

	@Override
	public List<ProduceNo> findAllByProduceNo(ProduceNo produceNo) {
		return produceNoRepository.findAll();
	}

	@Override
	public ProduceNo findByTable(String table) {
		return produceNoRepository.findByName(table);
	}

	//新增產生編號
	@Override
	@Transactional
	public ProduceNo createProduceNo(ProduceNo produceNo) {
		return produceNoRepository.save(produceNo);
	}


	//更新編號
	@Override
	@Transactional
	public ProduceNo updateProduceNo(ProduceNo produceNo) {
		return produceNoRepository.save(produceNo);
	}

	//自動新增或更新編號
	@Override
	public ProduceNo updateProduceNo(String no) {
		ProduceNo produceNo = null;
		if(no.charAt(0) == 'T'){
			if(produceNoRepository.findByName("TackleList") == null){
				produceNo = new ProduceNo();
				produceNo.setName("TackleList");
			} else{
				produceNo = produceNoRepository.findByName("TackleList");
			}
			produceNo.setDate(no.substring(1,9));
			produceNo.setNum(Integer.valueOf(no.substring(9,12)));
		} else if (no.charAt(0) == 'V') {
			if(produceNoRepository.findByName("VenueList") == null){
				produceNo = new ProduceNo();
				produceNo.setName("VenueList");
			} else{
				produceNo = produceNoRepository.findByName("VenueList");
			}
			produceNo.setDate(no.substring(1,9));
			produceNo.setNum(Integer.valueOf(no.substring(9,12)));
		} else {
			if(produceNoRepository.findByName("Rental") == null){
				produceNo = new ProduceNo();
				produceNo.setName("Rental");
			} else{
				produceNo = produceNoRepository.findByName("Rental");
			}
			produceNo.setDate(no.substring(0,8));
			produceNo.setNum(Integer.valueOf(no.substring(8,15)));
		}

		return produceNoRepository.save(produceNo);
	}

	//刪除編號
	@Override
	@Transactional
	public void deleteProduceNo(Integer id) {
		produceNoRepository.deleteById(id);
	}

}
