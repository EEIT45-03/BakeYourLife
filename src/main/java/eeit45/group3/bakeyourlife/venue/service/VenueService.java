package eeit45.group3.bakeyourlife.venue.service;

import eeit45.group3.bakeyourlife.venue.model.Venue;
import eeit45.group3.bakeyourlife.venue.model.VenuePicList;
import eeit45.group3.bakeyourlife.venue.model.VenueSort;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VenueService {

    //查詢全部的場地
    public List<Venue> findAllVenue();

    //查詢全部的場地,依場地名稱遞增排列
    public List<Venue> findByOrderByVenueNameAsc();

    //查詢全部的場地名稱
    public List<String> findAllVenueName();

    //依種類查詢全部的場地
    public List<Venue> findAllByVenueSort(String sort);

    //依種類與名稱查詢全部的場地
    public List<Venue> findAllByVenueNameAndVenueSort(String venueName, String sort);

    //依場地ID查詢場地
    public Venue findByVenueId(Integer venueId);

    //依場地名稱查詢場地
    public Venue findByVenueName(String venueName);

    //新增場地
    public Venue createVenue(Venue venue);

//    public Venue createVenue(Venue venue, MultipartFile[] file);

    //更新場地
    public Venue updateVenue(Venue venue);

    //刪除場地
    public void deleteVenue(Integer venueId);

    //檢查場地data
    public boolean checkVenue(Venue venue);



    //查詢全部的場地種類
    public List<VenueSort> findAllVenueSort();

    //依種類查詢全部的場地
    public List<Venue> findAllByVenueSort(Integer venueSortId);

    //查詢其一種類以外的場地
    public List<Venue> findAllByVenueSortNot(Integer venueSortId);

    //查詢TOP3場地
    public List<Venue> findByVenueTopThree();

    public boolean createVenuePicList(Venue venue);

}
