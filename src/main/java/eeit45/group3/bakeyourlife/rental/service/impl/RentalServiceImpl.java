package eeit45.group3.bakeyourlife.rental.service.impl;

import eeit45.group3.bakeyourlife.rental.dao.*;
import eeit45.group3.bakeyourlife.rental.dto.RentalRequest;
import eeit45.group3.bakeyourlife.rental.dto.TackleListRequest;
import eeit45.group3.bakeyourlife.rental.dto.VenueListRequest;
import eeit45.group3.bakeyourlife.rental.model.*;
import eeit45.group3.bakeyourlife.rental.service.RentalService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("rentalService")
@Transactional(readOnly = true)
public class RentalServiceImpl implements RentalService {


//	RentalDAO rentalDao;

	UserService userService;

	RentalRepository rentalRepository;

	VenueListRepository venueListRepository;

	TackleListRepository tackleListRepository;

	VenueRepository venueRepository;

	TackleRepository tackleRepository;

	@Autowired
	public RentalServiceImpl(TackleRepository tackleRepository,
							 UserService userService,
							 RentalRepository rentalRepository,
							 VenueListRepository venueListRepository,
							 TackleListRepository tackleListRepository,
							 VenueRepository venueRepository
			/* ,RentalDAO rentalDao*/) {

		this.userService = userService;
		this.rentalRepository = rentalRepository;
		this.venueListRepository = venueListRepository;
		this.tackleListRepository = tackleListRepository;
		this.venueRepository = venueRepository;
		this.tackleRepository = tackleRepository;
//		this.rentalDao = rentalDao;
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

	//新增租借單
	@Override
	@Transactional
	public Rental createRental(Rental rental) {
		return rentalRepository.save(rental);
	}

	@Override
	@Transactional
	public Rental createRental(RentalRequest rentalRequest) {
		Rental rental = new Rental();
		User user = userService.findByUserId(rentalRequest.getUserId());
		rental.setRentalNo(rentalRequest.getRentalNo());
		rental.setUser(user);
		rental.setType(rentalRequest.getListType());
		rental.setTotal(rentalRequest.getTotal());
		return rentalRepository.save(rental);
	}


	//更新租借單
	@Override
	@Transactional
	public Rental updateRental(Rental rental) {
		return rentalRepository.save(rental);
	}

	//刪除租借單
	@Override
	@Transactional
	public void deleteRental(Integer rentalId) {
		rentalRepository.deleteById(rentalId);
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
	@Transactional
	public VenueList createVenueList(Integer rentalId, VenueListRequest venueListRequest) {
		VenueList venueList = new VenueList();
		Rental rental = rentalRepository.findById(rentalId).orElse(null);
		Venue venue = venueRepository.findById(venueListRequest.getVenueId()).orElse(null);
		venueList.setVenueListNo(venueListRequest.getVenueListNo());
		venueList.setVenue(venue);
		venueList.setLendTime(venueListRequest.getLendTime());
		venueList.setEndTime(venueListRequest.getEndTime());
		venueList.setIngredients(venueListRequest.getIngredients());
		venueList.setPerson(venueListRequest.getPerson());
		venueList.setPrice(venueListRequest.getPrice());
		venueList.setRental(rental);
		return venueListRepository.save(venueList);
	}

	//更新場地租借清單
	@Override
	@Transactional
	public VenueList updateVenueList(VenueList venueList) {
		return venueListRepository.save(venueList);
	}

	//刪除場地租借清單
	@Override
	@Transactional
	public void deleteVenueList(Integer venueListId) {
		venueListRepository.deleteById(venueListId);
	}

	
	/*教室 DAO
	----------------------------------------------------------------*/

	//查詢全部的教室
	@Override
	public List<Venue> findAllVenue() {
		return venueRepository.findAll();
	}

	//依教室ID查詢教室
	@Override
	public Venue findByVenueId(Integer venueId) {
		return venueRepository.findById(venueId).orElse(null);
	}

	//依教室名稱查詢教室
	@Override
	public Venue findByVenueName(String venueName) {
		return venueRepository.findByVenueName(venueName);
	}

	//新增教室
	@Override
	@Transactional
	public Venue createVenue(Venue venue) {
		return venueRepository.save(venue);
	}


	//更新教室
	@Override
	@Transactional
	public Venue updateVenue(Venue venue) {
		return venueRepository.save(venue);
	}

	//刪除教室
	@Override
	@Transactional
	public void deleteVenue(Integer venueId) {
		venueRepository.deleteById(venueId);
	}
	
	
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
	public TackleList createTackleList(Integer rentalId, TackleListRequest tackleListRequest) {
		TackleList tackleList = new TackleList();
		Rental rental = rentalRepository.findById(rentalId).orElse(null);
		Tackle tackle = tackleRepository.findById(tackleListRequest.getTackleId()).orElse(null);
		tackleList.setTackleListId(tackleListRequest.getTackleListId());
		tackleList.setTackleListNo(tackleListRequest.getTackleListNo());
		tackleList.setTackle(tackle);
		tackleList.setLendDate(tackleListRequest.getLendDate());
		tackleList.setEndDate(tackleListRequest.getEndDate());
		tackleList.setReturnDate(tackleListRequest.getReturnDate());
		tackleList.setQuantity(tackleListRequest.getQuantity());
		tackleList.setPrice(tackleListRequest.getPrice());
		tackleList.setState(tackleListRequest.getState());
		tackleList.setRental(rental);
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

	
	/*器具 DAO
	----------------------------------------------------------------*/

	//查詢全部的器具
	@Override
	public List<Tackle> findAllTackle() {
		return tackleRepository.findAll();
	}

	//依器具ID查詢器具
	@Override
	public Tackle findByTackleId(Integer tackleId) {
		return tackleRepository.findById(tackleId).orElse(null);
	}

	//依器具名稱查詢器具
	@Override
	public Tackle findByTackleName(String tackleName) {
		return tackleRepository.findByTackleName(tackleName);
	}

	//新增器具
	@Override
	@Transactional
	public Tackle createTackle(Tackle tackle) {
		return tackleRepository.save(tackle);
	}

	//更新器具
	@Override
	@Transactional
	public Tackle updateTackle(Tackle tackle) {
		return tackleRepository.save(tackle);
	}

	//刪除器具
	@Override
	@Transactional
	public void deleteTackle(Integer tackleId) {
		tackleRepository.deleteById(tackleId);
	}
	
	
	
	/*會員 DAO
	----------------------------------------------------------------*/

	//查詢全部的會員
//	@Override
//	public List<User> findAllByUser() {
//		List<User> list = null;
//		list = rentalDao.findAllByUser();
//		return list;
//	}

	//依Id搜尋查詢會員
//	@Override
//	public User findByUserId(Integer userId) {
//		User user = null;
//		user = rentalDao.findByUserId(userId);
//		return user;
//	}
}
