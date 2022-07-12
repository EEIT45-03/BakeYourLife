package eeit45.group3.bakeyourlife.venue.service.impl;

import eeit45.group3.bakeyourlife.venue.dao.VenueRepository;
import eeit45.group3.bakeyourlife.venue.model.Venue;
import eeit45.group3.bakeyourlife.venue.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class VenueSerivceImpl implements VenueService {

    private VenueRepository venueRepository;


    @Autowired
    public VenueSerivceImpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    //查詢全部的教室
    @Override
    public List<Venue> findAllVenue() {
        return venueRepository.findAll();
    }

    //查詢全部的教室,依教室名稱遞增排列
    @Override
    public List<Venue> findByOrderByVenueNameAsc() {
        return venueRepository.findByOrderByVenueNameAsc();
    }

    //查詢全部的教室名稱
    public List<String> findAllVenueName(){return venueRepository.findAllVenueName();}

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

    @Override
    public boolean checkVenue(Venue venue) {
//        boolean check = false;
//
//        String name = venue.getVenueName().toUpperCase();
//        int index1 = name.charAt(0);
//
//        if (65 < index1 || index1 > 90 ){
//            System.out.println("----------場地名稱的第1個字元不是英文----------");
//            return false;
//        }
//        for(int i=1 ; i<name.length() ; i++){
//            if(Integer.valueOf(name.charAt(i))!=null){
//                int n = Integer.valueOf(name.charAt(i));
//                if(0>n || n>9) {
//                    System.out.println("----------場地名稱的第" + (i+1) + "個字元不是數字0~9----------");
//                    return false;
//                } else {
//                    System.out.println("----------場地名稱的第" + (i+1) + "個字元不是數字----------");
//                    return false;
//                }
//            }
//        }
//
//        if(venue.getPersonMax()==null){
//            System.out.println("----------場地人數上限為NULL----------");
            return false;
//        }
//
//
//        return check;
    }
}
