package eeit45.group3.bakeyourlife.rental.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eeit45.group3.bakeyourlife.rental.dao.RentalDAO;
import eeit45.group3.bakeyourlife.rental.dto.RentalRequest;
import eeit45.group3.bakeyourlife.rental.dto.TackleListRequest;
import eeit45.group3.bakeyourlife.rental.dto.VenueListRequest;
import eeit45.group3.bakeyourlife.rental.model.Classroom;
import eeit45.group3.bakeyourlife.rental.model.Rental;
import eeit45.group3.bakeyourlife.rental.model.Tackle;
import eeit45.group3.bakeyourlife.rental.model.TackleList;
import eeit45.group3.bakeyourlife.rental.model.VenueList;
import eeit45.group3.bakeyourlife.rental.service.RentalService;
import eeit45.group3.bakeyourlife.user.model.User;


@Service("rentalService")
@Transactional(readOnly = true)
public class RentalServiceImpl implements RentalService {

    @Autowired
    SessionFactory factory;

    @Autowired
    RentalDAO rentalDao;

//	public RentalServiceImpl() {
//		factory = HibernateUtils.getSessionFactory();
//		rentalDao = new RentalDAOimp();
//	}
	
	
	/*租借單 DAO
	----------------------------------------------------------------*/

    //查詢全部的租借單
    @Override
    @Transactional
    public List<Rental> findAllByRental() {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
        List<Rental> list = null;
//		try {
//			tx = session.beginTransaction();
        list = rentalDao.findAllByRental();
//		    tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
        return list;
    }

    //依租借單ID查詢租借單
    @Override
    public Rental findByRentalId(Integer rentalId) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
        Rental rental = null;
//		try {
//			tx = session.beginTransaction();
        rental = rentalDao.findByRentalId(rentalId);
//		    tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
        return rental;
    }

    //新增租借單
    @Override
    @Transactional
    public boolean createRental(Rental rental) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
        rentalDao.createRental(rental);
//		    tx.commit();
        return true;
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//		return false;
    }

    @Override
    @Transactional
    public boolean createRental(RentalRequest rentalRequest) {
        Rental rental = new Rental();
        User user = rentalDao.findByUserId(rentalRequest.getUserId());
        rental.setRentalNO(rentalRequest.getRentalNO());
        rental.setUser(user);
        rental.setType(rentalRequest.getListType());
        rental.setTotal(rentalRequest.getTotal());
        return rentalDao.createRental(rental);
    }


    //更新租借單
    @Override
    @Transactional
    public boolean updateRental(Rental rental) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
        rentalDao.updateRental(rental);
//		    tx.commit();
        return true;
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//		return false;
    }

    //刪除租借單
    @Override
    @Transactional
    public boolean deleteRental(Integer rentalId) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
        rentalDao.deleteRental(rentalId);
//		    tx.commit();
        return true;
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//		return false;
    }

	/*場地租借清單 DAO
	----------------------------------------------------------------*/

    //查詢全部的場地租借清單
    @Override
    public List<VenueList> findAllByVenueList() {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
        List<VenueList> list = null;
//		try {
//			tx = session.beginTransaction();
        list = rentalDao.findAllByVenueList();
//		    tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
        return list;
    }

    //依清單ID查詢場地租借清單
    @Override
    public VenueList findByVenueListId(Integer venueListId) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
        VenueList venueList = null;
//		try {
//			tx = session.beginTransaction();
        venueList = rentalDao.findByVenueListId(venueListId);
//		    tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
        return venueList;
    }

    //依租借單ID查詢場地租借清單
    @Override
    public List<VenueList> findVenueListByFK_RentalId(Integer FK_rentalId) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
        List<VenueList> list = null;
//		try {
//			tx = session.beginTransaction();
        list = rentalDao.findVenueListByFK_RentalId(FK_rentalId);
//		    tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
        return list;
    }

    //依租借時間查詢場地
    @Override
    public Long findDateBetweenByFK_ClassId(Integer FK_classId, Date lendTime, Date returnTime) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
        Long sum = null;
//		try {
//			tx = session.beginTransaction();
        sum = rentalDao.findDateBetweenByFK_ClassId(FK_classId, lendTime, returnTime);
//		    tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
        return sum;
    }

    //新增場地租借清單
    @Override
    @Transactional
    public boolean createVenueList(VenueList venueList) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
        rentalDao.createVenueList(venueList);
//		    tx.commit();
        return true;
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//		return false;
    }

    @Override
    @Transactional
    public boolean createVenueList(Integer rentalId, VenueListRequest venueListRequest) {
        VenueList venueList = new VenueList();
        Rental rental = rentalDao.findByRentalId(rentalId);
        Classroom room = rentalDao.findByClassName(venueListRequest.getClassName());
        venueList.setVenueListNo(venueListRequest.getVenueListNo());
        venueList.setClassroom(room);
        venueList.setLendTime(venueListRequest.getLendTime());
        venueList.setReturnTime(venueListRequest.getReturnTime());
        venueList.setPerson(venueListRequest.getPerson());
        venueList.setPrice(venueListRequest.getPrice());
        venueList.setRental(rental);
        return rentalDao.createVenueList(venueList);
    }

    //更新場地租借清單
    @Override
    @Transactional
    public boolean updateVenueList(VenueList venueList) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
        rentalDao.updateVenueList(venueList);
//		    tx.commit();
        return true;
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//		return false;
    }

    //刪除場地租借清單
    @Override
    @Transactional
    public boolean deleteVenueList(Integer venueListId) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
        rentalDao.deleteVenueList(venueListId);
//		    tx.commit();
        return true;
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//		return false;
    }

	
	/*教室 DAO
	----------------------------------------------------------------*/

    //查詢全部的教室
    @Override
    public List<Classroom> findAllByClassroom() {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
        List<Classroom> list = null;
//		try {
//			tx = session.beginTransaction();
        list = rentalDao.findAllByClassroom();
//		    tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
        return list;
    }

    //依教室ID查詢教室
    @Override
    public Classroom findByClassId(Integer classId) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
        Classroom classroom = null;
//		try {
//			tx = session.beginTransaction();
        classroom = rentalDao.findByClassId(classId);
//		    tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
        return classroom;
    }

    //依教室名稱查詢教室
    @Override
    public Classroom findByClassName(String className) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
        Classroom classroom = null;
//		try {
//			tx = session.beginTransaction();
        classroom = rentalDao.findByClassName(className);
//		    tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
        return classroom;
    }

    //新增教室
    @Override
    @Transactional
    public boolean createClassroom(Classroom classroom) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
        rentalDao.createClassroom(classroom);
//		    tx.commit();
        return true;
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//		return false;
    }

    //更新教室
    @Override
    @Transactional
    public boolean updateClassroom(Classroom classroom) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
        rentalDao.updateClassroom(classroom);
//		    tx.commit();
        return true;
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//		return false;
    }

    //刪除教室
    @Override
    @Transactional
    public boolean deleteClassroom(Integer classId) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
        rentalDao.deleteClassroom(classId);
//		    tx.commit();
        return true;
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//		return false;
    }
	
	
	/*器具租借清單 DAO
	----------------------------------------------------------------*/

    //查詢全部的器具租借清單
    @Override
    public List<TackleList> findAllByTackleList() {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
        List<TackleList> list = null;
//		try {
//			tx = session.beginTransaction();
        list = rentalDao.findAllByTackleList();
//		    tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
        return list;
    }

    //依清單ID查詢器具租借清單
    @Override
    public TackleList findByTackleListId(Integer tackleListId) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
        TackleList tackleList = null;
//		try {
//			tx = session.beginTransaction();
        tackleList = rentalDao.findByTackleListId(tackleListId);
//		    tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
        return tackleList;
    }

    //依租借單ID查詢器具租借清單
    @Override
    public List<TackleList> findTackleListByFK_RentalId(Integer FK_RentalId) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
        List<TackleList> list = null;
//		try {
//			tx = session.beginTransaction();
        list = rentalDao.findTackleListByFK_RentalId(FK_RentalId);
//		    tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
        return list;
    }

    //依租借時間查詢器具
    @Override
    public Long findDateBetweenByFK_TackleId(Integer FK_tackleId, Date lendTime, Date returnTime) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
        Long sum = null;
//		try {
//			tx = session.beginTransaction();
        sum = rentalDao.findDateBetweenByFK_TackleId(FK_tackleId, lendTime, returnTime);
//		    tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
        return sum;
    }

    //新增器具租借清單
    @Override
    @Transactional
    public boolean createTackleList(TackleList tackleList) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
        rentalDao.createTackleList(tackleList);
//		    tx.commit();
        return true;
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//		return false;
    }

    @Override
    @Transactional
    public boolean createTackleList(Integer rentalId, TackleListRequest tackleListRequest) {
        TackleList tackleList = new TackleList();
        Rental rental = rentalDao.findByRentalId(rentalId);
        Tackle tackle = rentalDao.findByTackleName(tackleListRequest.getTackleName());
        tackleList.setTackleListNo(tackleListRequest.getTackleListNo());
        tackleList.setTackle(tackle);
        tackleList.setLendTime(tackleListRequest.getLendTime());
        tackleList.setReturnTime(tackleListRequest.getReturnTime());
        tackleList.setQuantity(tackleListRequest.getQuantity());
        tackleList.setPrice(tackleListRequest.getPrice());
        tackleList.setRental(rental);
        return rentalDao.createTackleList(tackleList);
    }

    //更新器具租借清單
    @Override
    @Transactional
    public boolean updateTackleList(TackleList tackleList) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
        rentalDao.updateTackleList(tackleList);
//		    tx.commit();
        return true;
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//		return false;
    }

    //刪除場地租借清單
    @Override
    @Transactional
    public boolean deleteTackleList(Integer tackleListId) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
        rentalDao.deleteTackleList(tackleListId);
//		    tx.commit();
        return true;
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//		return false;
    }

	
	/*器具 DAO
	----------------------------------------------------------------*/

    //查詢全部的器具
    @Override
    public List<Tackle> findAllByTackle() {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
        List<Tackle> list = null;
//		try {
//			tx = session.beginTransaction();
        list = rentalDao.findAllByTackle();
//		    tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
        return list;
    }

    //依器具ID查詢器具
    @Override
    public Tackle findByTackleId(Integer tackleId) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
        Tackle tackle = null;
//		try {
//			tx = session.beginTransaction();
        tackle = rentalDao.findByTackleId(tackleId);
//		    tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
        return tackle;
    }

    //依器具名稱查詢器具
    @Override
    public Tackle findByTackleName(String tackleName) {
        Tackle tackle = rentalDao.findByTackleName(tackleName);
        return tackle;
    }

    //新增器具
    @Override
    @Transactional
    public boolean createTackle(Tackle tackle) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
        rentalDao.createTackle(tackle);
//		    tx.commit();
        return true;
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//		return false;
    }

    //更新器具
    @Override
    @Transactional
    public boolean updateTackle(Tackle tackle) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
        rentalDao.updateTackle(tackle);
//		    tx.commit();
        return true;
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//		return false;
    }

    //刪除器具
    @Override
    @Transactional
    public boolean deleteTackle(Integer tackleId) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
        rentalDao.deleteTackle(tackleId);
//		    tx.commit();
        return true;
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
//		return false;
    }
	
	
	
	/*會員 DAO
	----------------------------------------------------------------*/

    //查詢全部的會員
    @Override
    public List<User> findAllByUser() {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
        List<User> list = null;
//		try {
//			tx = session.beginTransaction();
        list = rentalDao.findAllByUser();
//		    tx.commit();
//		} catch(Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
        return list;
    }

    //依Id搜尋查詢會員
    @Override
    public User findByUserId(Integer userId) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
        User user = null;
//		try {
//			tx = session.beginTransaction();
        user = rentalDao.findByUserId(userId);
//		   
        return user;
    }


}
