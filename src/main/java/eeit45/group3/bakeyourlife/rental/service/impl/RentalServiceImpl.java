package eeit45.group3.bakeyourlife.rental.service.impl;

import eeit45.group3.bakeyourlife.email.service.EmailService;
import eeit45.group3.bakeyourlife.rental.dao.*;
import eeit45.group3.bakeyourlife.rental.dto.TackleListRequest;
import eeit45.group3.bakeyourlife.rental.dto.VenueListRequest;
import eeit45.group3.bakeyourlife.rental.model.*;
import eeit45.group3.bakeyourlife.rental.service.RentalService;
import eeit45.group3.bakeyourlife.rental.utils.AvailableQuantity;
import eeit45.group3.bakeyourlife.tackle.model.Tackle;
import eeit45.group3.bakeyourlife.tackle.service.TackleService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import eeit45.group3.bakeyourlife.venue.model.Venue;
import eeit45.group3.bakeyourlife.venue.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Service("rentalService")
@Transactional(readOnly = true)
public class RentalServiceImpl implements RentalService{

	UserService userService;

	TackleService tackleService;

	VenueService venueService;

	RentalRepository rentalRepository;

	VenueListRepository venueListRepository;

	TackleListRepository tackleListRepository;

	TackleBagRepository tackleBagRepository;

	ProduceNoRepository produceNoRepository;

	EmailService emailService;

	@Autowired
	public RentalServiceImpl(UserService userService, TackleService tackleService, VenueService venueService, RentalRepository rentalRepository, VenueListRepository venueListRepository, TackleListRepository tackleListRepository, TackleBagRepository tackleBagRepository, ProduceNoRepository produceNoRepository, EmailService emailService) {
		this.userService = userService;
		this.tackleService = tackleService;
		this.venueService = venueService;
		this.rentalRepository = rentalRepository;
		this.venueListRepository = venueListRepository;
		this.tackleListRepository = tackleListRepository;
		this.produceNoRepository = produceNoRepository;
		this.tackleBagRepository = tackleBagRepository;
		this.emailService = emailService;
	}





/*租借單 DAO
	----------------------------------------------------------------*/

	//查詢全部的租借單
	@Override
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

	@Override
	public List<Rental> findAllByState(String state) {
		return rentalRepository.findAllByState(state);
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
	@Override
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
//		rental.setRentalDate(new Date());
		return rentalRepository.save(rental);
	}

	//更新租借單
	@Override
	@Transactional
	public Rental updateRental(Rental rental) {
		Rental rentalDb = findByRentalNo(rental.getRentalNo());
		if("器具".equals(rental.getType())){
			rental.setTackleList(rentalDb.getTackleList());
		} else if("場地".equals(rental.getType())){
			rental.setVenueList(rentalDb.getVenueList());
		} else{
			return null;
		}
		if("已付款".equals(rental.getState())){
			User user = userService.findByUserId(rental.getUser().getUserId());
			String email = user.getEmail();
			try {
				emailService.sendRentalMail(email, "[Bake Your Life 烘焙材料網] 租借單已付款成功通知",rental,"rentalfinish");
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}

		return rentalRepository.save(rental);
	}

//	public Rental updateRental(Integer rentalId){
//		Rental rental = findByRentalId(rentalId);
//		if(rental != null) {
//			Long sum = findTackleListPriceSumByRental(rental);
//			if (sum != null) {
//				rental.setTotal(sum.intValue());
//			} else {
//				rental.setTotal(0);
//			}
//		}
//		return updateRental(rental);
//	}
	//刪除租借單
	@Override
	@Transactional
	public void deleteRental(Integer rentalId) {
		rentalRepository.deleteById(rentalId);
	}


	//建立租借單請求資料
	@Override
	@Transactional
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

	@Override
	public Rental CheckUserRental(Integer userId, String listType) {
		User user = userService.findByUserId(userId);
		Rental rental = rentalRepository.findByUserAndStateAndType(user, "未下單", listType);
		if(rental != null){
			return rental;
		} else {
			rental = new Rental();
			rental.setUser(user);
			rental.setType(listType);
			rental.setTotal(0);
		}

		return rental;
	}

	@Override
	public Rental CheckUserRental(User user, String state, String listType) {
		Rental rental = rentalRepository.findByUserAndStateAndType(user, state, listType);
		if(rental != null){
			return rental;
		}

		return null;
	}

	@Override
	public Rental updateRentalPic(Rental rental) {
		Long sum = null;
		if("器具".equals(rental.getType())){
			sum = tackleListRepository.findPriceSumByRental(rental);
		} else if("場地".equals(rental.getType())){
			sum = venueListRepository.findPriceSumByRental(rental);
		}
		rental.setTotal(sum.intValue());
		Rental rentalDb = rentalRepository.save(rental);
		return rentalDb;
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


	//查詢某時間的場地使用狀況
	@Override
	public List<AvailableQuantity> getVenueSelect(String name, Date date){
		Venue venue = venueService.findByVenueName(name);
		return venueListRepository.findSumByVenueAndDatetime(venue.getVenueId(),date);
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
		if(venueList.getVenue().getVenueId() != null){
			Venue venue = venueService.findByVenueId(venueList.getVenue().getVenueId());
			venueList.setVenue(venue);
		}
		venueList.getRental().setRentalDate(new Date());

		return venueListRepository.save(venueList);
	}

	@Override
	@Transactional
	public VenueList createVenueList(VenueListRequest venueListRequest, Principal principal) throws ParseException {

		User user = userService.findByUsername(principal.getName());

		Rental rental = rentalRepository.findByUserAndStateAndType(user,"未下單","場地");
		if(rental == null) {
			rental = new Rental();
			rental = createRentalNoRequest();
			rental.setState("未下單");
			rental.setType("場地");
			rental.setUser(user);
			updateProduceNo(rental.getRentalNo());
			rentalRepository.save(rental);
		}

		VenueList venueList = createVenueListNoRequest(rental);

		if(venueListRequest.getVenueName()!=null){
			Venue venue = venueService.findByVenueName(venueListRequest.getVenueName());
			venueList.setVenue(venue);
		}
		if(venueListRequest.getRentalDate()!=null){
			String date = new SimpleDateFormat("yyyy-MM-dd").format(venueListRequest.getRentalDate());

			venueList.setRentalDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
		}
		if(venueListRequest.getPeriod()!=null){
			venueList.setPeriod(venueListRequest.getPeriod());
		}
		if(venueListRequest.getPerson()!=null){
			venueList.setPerson(venueListRequest.getPerson());
		}
		if(venueListRequest.getPrice()!=null){
			venueList.setPrice(venueListRequest.getPrice());
		}
		venueList.setIngredients("N");


		updateProduceNo(venueList.getVenueListNo());
		return venueListRepository.save(venueList);
	}

	//更新場地租借清單
	@Override
	@Transactional
	public VenueList updateVenueList(VenueList venueList) {
		Venue venue = venueService.findByVenueId(venueList.getVenue().getVenueId());
		venueList.setVenue(venue);
		String period = venueList.getPeriod();
		int num1 = Integer.valueOf(period.substring(0,2));
		System.out.println(num1);
		int num2 = Integer.valueOf(period.substring(6,8));
		System.out.println(num2);
		int num = num2-num1;
		int price = num * venueList.getPerson() * venueList.getVenue().getHrPrice();
		venueList.setPrice(price);
		venueList.setIngredients("N");
		return venueListRepository.save(venueList);
	}

	public VenueList updateVenueList(Rental rental, VenueListRequest venueListRequest){

		for (VenueList item : rental.getVenueList()){
			if(item.getRentalDate() == venueListRequest.getRentalDate()){
				if(item.getPeriod() == venueListRequest.getPeriod()){
					int person = item.getPerson() + venueListRequest.getPerson();
					int price = item.getPrice() + venueListRequest.getPrice();
					item.setPerson(person);
					item.setPrice(price);
					return venueListRepository.save(item);
				}
			}
		}
		return null;
	}


	//刪除場地租借清單
	@Override
	@Transactional
	public void deleteVenueList(Integer venueListId) {
		venueListRepository.deleteById(venueListId);
	}

	@Override
	@Transactional
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


	@Override
	public List<VenueList> findByRentalAndVenueAndRentalDateAndPeriod(Rental rental, Venue venue, Date date, String state) {
		return venueListRepository.findByRentalAndVenueAndRentalDateAndPeriod(rental,venue,date,state);
	}

	public boolean checkVenueListRequest(VenueListRequest venueListRequest){




		return false;
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
//	@Override
//	public Long findTackleListPriceSumByRental(Rental rental) {
//		return tackleListRepository.findPriceSumByRental(rental);
//	}

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
		Rental rental = rentalRepository.findByRentalNo(tackleList.getRental().getRentalNo());
		tackleList.setRental(rental);
		return tackleListRepository.save(tackleList);
	}

	@Override
	@Transactional
	public TackleList createTackleList(TackleListRequest tackleListRequest) {
		TackleList tackleList = new TackleList();
		if(tackleListRequest.getRental().getRentalNo()!=null) {
			Rental rental = rentalRepository.findByRentalNo(tackleListRequest.getRental().getRentalNo());
			rental.setRentalDate(new Date());
			tackleList.setRental(rental);
		}
		if(tackleListRequest.getTackleListNo()!=null){
			tackleList.setTackleListNo(tackleListRequest.getTackleListNo());
		}
		if (tackleListRequest.getLendDate()!=null){
			tackleList.setLendDate(tackleListRequest.getLendDate());
		}
		if (tackleListRequest.getEndDate()!=null){
			tackleList.setEndDate(tackleListRequest.getEndDate());
		}
		if (tackleListRequest.getTotal()!=null){
			tackleList.setTotal(tackleListRequest.getTotal());
		}
		if (tackleListRequest.getState()!=null){
			tackleList.setState(tackleListRequest.getState());
		}


		tackleList = tackleListRepository.save(tackleList);

		TackleBag tackleBag = new TackleBag(tackleList);
		Integer[] tackles = tackleListRequest.getTackleIds();
		Integer[] quantitys = tackleListRequest.getQuantitys();
		Integer[] prices = tackleListRequest.getPrices();

		for (int i=0;i<tackles.length;i++){
			Tackle tackle = tackleService.findByTackleId(tackles[i]);

			if (tackle != null) {
				tackleBag.setTackle(tackle);
			} else {
				continue;
			}
			if (quantitys[i] != null){
				tackleBag.setQuantity(quantitys[i]);
			} else {
				continue;
			}
			if (prices[i] != null){
				tackleBag.setPrice(prices[i]);
			} else {
				continue;
			}

			tackleBagRepository.save(tackleBag);
		}

		return tackleList;
	}

	//更新器具租借清單
	@Override
	@Transactional
	public TackleList updateTackleList(TackleList tackleList) {
		Rental rental = rentalRepository.findByRentalNo(tackleList.getRental().getRentalNo());
		tackleList.setRental(rental);
		return tackleListRepository.save(tackleList);
	}

	//刪除場地租借清單
	@Override
	@Transactional
	public void deleteTackleList(Integer tackleListId) {
		tackleListRepository.deleteById(tackleListId);
	}

	@Override
	@Transactional
	public TackleListRequest createTackleListNoRequest(Rental rental) {

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

		TackleListRequest tackleList = new TackleListRequest();
		tackleList.setTackleListNo(no);
//		tackleList.setPrice(0;
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
	@Transactional
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
			String b = no.substring(1,9);
			produceNo.setDate(no.substring(1,9));
			Integer a = Integer.valueOf(no.substring(9,12));
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


	@Override
	public void sendRentalMail(Rental rental) throws UnsupportedEncodingException, MessagingException {

	}
}
