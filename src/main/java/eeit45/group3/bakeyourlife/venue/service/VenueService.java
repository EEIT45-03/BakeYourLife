package eeit45.group3.bakeyourlife.venue.service;

import eeit45.group3.bakeyourlife.venue.model.Venue;

import java.util.List;

public interface VenueService {

    //查詢全部的教室
    public List<Venue> findAllVenue();

    //查詢全部的教室,依教室名稱遞增排列
    public List<Venue> findByOrderByVenueNameAsc();

    //查詢全部的教室名稱
    public List<String> findAllVenueName();


    //依教室ID查詢教室
    public Venue findByVenueId(Integer venueId);

    //依教室名稱查詢教室
    public Venue findByVenueName(String venueName);

    //新增教室
    public Venue createVenue(Venue venue);
//	public boolean createVenue(VenueRequest venueRequest);

    //更新教室
    public Venue updateVenue(Venue venue);

    //刪除教室
    public void deleteVenue(Integer venueId);

    //檢查教室data
    public boolean checkVenue(Venue venue);
}
