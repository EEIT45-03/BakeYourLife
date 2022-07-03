package eeit45.group3.bakeyourlife.rental.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eeit45.group3.bakeyourlife.rental.dao.RentalDAO;
import eeit45.group3.bakeyourlife.rental.model.Venue;
import eeit45.group3.bakeyourlife.rental.model.Rental;
import eeit45.group3.bakeyourlife.rental.model.Tackle;
import eeit45.group3.bakeyourlife.rental.model.TackleList;
import eeit45.group3.bakeyourlife.rental.model.VenueList;
import eeit45.group3.bakeyourlife.user.model.User;


@Repository("rentalDao")
@Transactional
public class RentalDAOimp implements RentalDAO {
	
	@Autowired
	SessionFactory factory;

//	public RentalDAOimp() {
//		factory = HibernateUtils.getSessionFactory();
//	}

	/*租借單 DAO
	----------------------------------------------------------------*/

	//查詢全部的租借單
	@Override
	public List<Rental> findAllByRental() {
		Session session = factory.getCurrentSession();
		List<Rental> rentals = null;
		if(session != null) {
			String hql = "FROM Rental";
			rentals = session.createQuery(hql, Rental.class)
										  .getResultList();
		}
		return rentals;
	}

	//依租借單ID查詢租借單
	@Override
	public Rental findByRentalId(Integer rentalId) {
		Session session = factory.getCurrentSession();
		Rental rental = session.get(Rental.class, rentalId);
		return rental;
	}

	//新增租借單
	@Override
	public boolean createRental(Rental rental) {
		Session session = factory.getCurrentSession();
		session.save(rental);
		return true;
	}


	//更新租借單
	@Override
	public boolean updateRental(Rental rental) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(rental);
		return true;
	}

	//刪除租借單
	@Override
	public boolean deleteRental(Integer rentalId) {
		Session session = factory.getCurrentSession();
		Rental rental = session.get(Rental.class, rentalId);
		session.delete(rental);
		return true;
	}

	/*場地租借清單 DAO
	----------------------------------------------------------------*/

	//查詢全部的場地租借清單
	@Override
	public List<VenueList> findAllByVenueList() {
		Session session = factory.getCurrentSession();
		List<VenueList> venueLists = null;
		if(session != null) {
			String hql = "FROM VenueList";
			venueLists = session.createQuery(hql, VenueList.class)
										  .getResultList();
		}
		return venueLists;
	}

	//依清單ID查詢場地租借清單
	@Override
	public VenueList findByVenueListId(Integer venueListId) {
		Session session = factory.getCurrentSession();
		VenueList venueList = session.get(VenueList.class, venueListId);

		return venueList;
	}

	//依租借單ID查詢場地租借清單
	@Override
	public List<VenueList> findVenueListByFK_RentalId(Integer FK_RentalId) {
		Session session = factory.getCurrentSession();
		List<VenueList> venueLists = null;
		if(session != null) {
			String hql = "FROM VenueList WHERE FK_rentalId = :id";
			venueLists = session.createQuery(hql, VenueList.class)
					.setParameter("id", FK_RentalId)
					.getResultList();
		}
		return venueLists;
	}

	//依租借時間查詢場地
	@Override
	public Long findDateBetweenByFK_VenueId(Integer FK_venueId, Date lendTime, Date returnTime) {
		Session session = factory.getCurrentSession();
		Long sum = null;
		if(session != null) {
			String hql = "select Count(FK_venueId) FROM VenueList WHERE FK_venueId = :venueId AND lendTime <= :lTime AND endTime <= :eTime ";
			sum =	session.createQuery(hql, Long.class)
					.setParameter("venueId", FK_venueId)
					.setParameter("lTime", lendTime)
					.setParameter("eTime", returnTime)
					.getSingleResult();
		}
		return sum;
	}

	//新增場地租借清單
	@Override
	public boolean createVenueList(VenueList venueList) {
		Session session = factory.getCurrentSession();
		session.save(venueList);
		return true;
	}

	//更新場地租借清單
	@Override
	public boolean updateVenueList(VenueList venueList) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(venueList);
		return true;
	}

	//刪除場地租借清單
	@Override
	public boolean deleteVenueList(Integer venueListId) {
		Session session = factory.getCurrentSession();
		VenueList  venueList = session.get(VenueList.class, venueListId);
		session.delete(venueList);
		return true;
	}

	/*教室 DAO
	----------------------------------------------------------------*/

	//查詢全部的教室
	@Override
	public List<Venue> findAllByVenue() {
		Session session = factory.getCurrentSession();
		List<Venue> venues = null;
		if(session != null) {
			String hql = "FROM Venue";
			venues = session.createQuery(hql, Venue.class)
										  .getResultList();
		}
		return venues;
	}

	//依教室ID查詢教室
	@Override
	public Venue findByVenueId(Integer venueId) {
		Session session = factory.getCurrentSession();
		Venue venue = session.get(Venue.class, venueId);
		return venue;
	}

	//依教室名稱查詢教室
	@Override
	public Venue findByVenueName(String venueName) {
		Session session = factory.getCurrentSession();
		Venue venue = null;
		if(session != null) {
			String hql = "FROM Venue WHERE venueName = :name";
			venue = session.createQuery(hql, Venue.class)
					.setParameter("name", venueName)
					.getSingleResult();
		}
		return venue;
	}

	//新增教室
	@Override
	public boolean createVenue(Venue venue) {
		Session session = factory.getCurrentSession();
		session.save(venue);
		return true;
	}

	//更新教室
	@Override
	public boolean updateVenue(Venue venue) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(venue);
		return true;
	}

	//刪除教室
	@Override
	public boolean deleteVenue(Integer venueId) {
		Session session = factory.getCurrentSession();
		Venue  venue = session.get(Venue.class ,venueId);
		session.delete(venue);
		return true;
	}

	/*器具租借清單 DAO
	----------------------------------------------------------------*/

	//查詢全部的器具租借清單
	@Override
	public List<TackleList> findAllByTackleList() {
		Session session = factory.getCurrentSession();
		List<TackleList> tackleLists = null;
		if(session != null) {
			String hql = "FROM TackleList";
			tackleLists = session.createQuery(hql, TackleList.class)
										  .getResultList();
		}
		return tackleLists;
	}

	//依清單ID查詢器具租借清單
	@Override
	public TackleList findByTackleListId(Integer tackleListId) {
		Session session = factory.getCurrentSession();
		TackleList tackleLists = session.get(TackleList.class, tackleListId);

		return tackleLists;
	}

	//依租借單ID查詢器具租借清單
	@Override
	public List<TackleList> findTackleListByFK_RentalId(Integer FK_RentalId) {
		Session session = factory.getCurrentSession();
		List<TackleList> tackleLists = null;
		if(session != null) {
			String hql = "FROM VenueList WHERE FK_rentalId = :id";
			tackleLists = session.createQuery(hql, TackleList.class)
					.setParameter("id", FK_RentalId)
					.getResultList();
		}
		return tackleLists;
	}

	//依租借時間查詢器具
	@Override
	public Long findDateBetweenByFK_TackleId(Integer FK_tackleId, Date lendTime, Date returnTime) {
		Session session = factory.getCurrentSession();
		Long sum = null;
		if(session != null) {
			String hql = "select Count(FK_tackleId) FROM TackleList WHERE FK_tackleId = :tackleId AND lendTime <= :lTime AND endTime <= :rTime ";
			sum =	session.createQuery(hql, Long.class)
					.setParameter("tackleId", FK_tackleId)
					.setParameter("lTime", lendTime)
					.setParameter("rTime", returnTime)
					.getSingleResult();
		}
		return sum;
	}

	//新增器具租借清單
	@Override
	public boolean createTackleList(TackleList tackleList) {
		Session session = factory.getCurrentSession();
		session.save(tackleList);
		return true;
	}

	//更新器具租借清單
	@Override
	public boolean updateTackleList(TackleList tackleList) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(tackleList);
		return true;
	}

	//刪除器具租借清單
	@Override
	public boolean deleteTackleList(Integer tackleListId) {
		Session session = factory.getCurrentSession();
		TackleList  tackleList = session.get(TackleList.class, tackleListId);
		session.delete(tackleList);
		return true;
	}

	/*器具 DAO
	----------------------------------------------------------------*/

	//查詢全部的器具
	public List<Tackle>  findAllByTackle(){
		Session session = factory.getCurrentSession();
		List<Tackle> tackle = null;
		if(session != null) {
			String hql = "FROM Tackle";
			tackle = session.createQuery(hql, Tackle.class)
										  .getResultList();
		}
		return tackle;
	}

	//依教室ID查詢器具
	public Tackle findByTackleId(Integer tackleId) {
		Session session = factory.getCurrentSession();
		Tackle tackle = session.get(Tackle.class, tackleId);
		return tackle;
	}

	//依器具名稱查詢器具
	@Override
	public Tackle findByTackleName(String tackleName) {
		Session session = factory.getCurrentSession();
		Tackle tackle = null;
		if(session != null) {
			String hql = "FROM Tackle WHERE tackleName = :name";
			tackle = session.createQuery(hql, Tackle.class)
					.setParameter("name", tackleName)
					.getSingleResult();
		}
		return tackle;
	}

	//新增器具
	public boolean createTackle(Tackle tackle) {
		Session session = factory.getCurrentSession();
		session.save(tackle);
		return true;
	}

	//更新器具
	public boolean updateTackle(Tackle tackle) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(tackle);
		return true;
	}

	//刪除器具
	public boolean deleteTackle(Integer tackleId) {
		Session session = factory.getCurrentSession();
		Tackle  tackle = session.get(Tackle.class ,tackleId);
		session.delete(tackle);
		return true;
	}


	/*會員 DAO
	----------------------------------------------------------------*/

	//查詢全部的會員
	@Override
	public List<User> findAllByUser() {
		String hql = "FROM Users";
		Session session = factory.getCurrentSession();
		List<User> uesrs = session.createQuery(hql, User.class)
							 		.getResultList();
		return uesrs;
	}

	//依Id搜尋查詢會員
	@Override
	public User findByUserId(Integer userlId) {
		Session session = factory.getCurrentSession();
		User user = session.get(User.class, userlId);
		return user;
	}





//	@Override
//	public Date stringToDate(String data) {
//		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
//		java.util.Date datetime = null;
//		try {
//			datetime = dateFormatter.parse(data);
//		} catch (ParseException e) {
//			System.err.println("date:" + datetime + ",異常" + e);
//		}
//		return datetime;
//	}
//
//	@Override
//	public Date stringToDate(String date, String time) {
//		String datetimeStr = date + " " + time;
//		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-mm-dd hh:mm");
//		java.util.Date datetime = null;
//		try {
//			datetime = dateFormatter.parse(datetimeStr);
//		} catch (ParseException e) {
//			System.err.println("date:" + datetime + ",異常" + e);
//		}
//		return datetime;
//	}
//
//	@Override
//	public java.sql.Date DateUtilToSql(Date date) {
//		java.sql.Date datetime = null;
//		datetime = new java.sql.Date(date.getTime());
//		return datetime;
//	}

}