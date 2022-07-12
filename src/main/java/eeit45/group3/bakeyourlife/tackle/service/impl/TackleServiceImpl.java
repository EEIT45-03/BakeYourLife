package eeit45.group3.bakeyourlife.tackle.service.impl;

import eeit45.group3.bakeyourlife.tackle.dao.TackleRepository;
import eeit45.group3.bakeyourlife.tackle.dao.TackleSortRepository;
import eeit45.group3.bakeyourlife.tackle.model.Tackle;
import eeit45.group3.bakeyourlife.tackle.model.TackleSort;
import eeit45.group3.bakeyourlife.tackle.service.TackleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TackleServiceImpl implements TackleService {

    private TackleRepository tackleRepository;

    private TackleSortRepository tackleSortRepository;

    @Autowired
    public TackleServiceImpl(TackleRepository tackleRepository, TackleSortRepository tackleSortRepository) {
        this.tackleRepository = tackleRepository;
        this.tackleSortRepository = tackleSortRepository;
    }



    //查詢全部的器具
    @Override
    public List<Tackle> findAllTackle() {
        return tackleRepository.findAll();
    }


    //查詢全部的器具名稱
    @Override
    public List<String> findAllTackleName(){
        return tackleRepository.findAllTackleName();
    }

    //依種類查詢全部的器具
    public List<Tackle> findAllByTackleSort(String sort){
        TackleSort sortDb = tackleSortRepository.findBySort(sort);

        return  tackleRepository.findByTackleSort(sortDb);
    }

    //依種類查詢全部的器具
    public List<Tackle> findAllByTackleNameAndTackleSort(String tackleName, String sort){
        TackleSort sortDb = tackleSortRepository.findBySort(sort);
        return tackleRepository.findByTackleNameAndTackleSort(tackleName,sortDb);
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
        TackleSort sort = tackleSortRepository.findById(tackle.getTackleSort().getTackleSortId()).orElse(null);
        tackle.setTackleSort(sort);
        return tackleRepository.save(tackle);
    }

    //更新器具
    @Override
    @Transactional
    public Tackle updateTackle(Tackle tackle) {
        TackleSort sort = tackleSortRepository.findById(tackle.getTackleSort().getTackleSortId()).orElse(null);
        tackle.setTackleSort(sort);
        if(tackle.getPicture()==null){
            Tackle tDb = findByTackleId(tackle.getTackleId());
            tackle.setPicture(tDb.getPicture());
        }
        return tackleRepository.save(tackle);
    }


    //刪除器具
    @Override
    @Transactional
    public void deleteTackle(Integer tackleId) {
        tackleRepository.deleteById(tackleId);
    }

    //查詢全部的器具類別
    @Override
    public List<TackleSort> findAllTackleSort() {
        return tackleSortRepository.findAll();
    }

    //依ID查詢全部的器具類別
    @Override
    public TackleSort findByTackleSortId(Integer tackleSortId) {
        return tackleSortRepository.findById(tackleSortId).orElse(null);
    }


    //新增器具類別
    @Override
    public TackleSort createTackleSort(TackleSort tackleSort) {
        return tackleSortRepository.save(tackleSort);
    }

    //更新器具類別
    @Override
    public TackleSort updateTackleSort(TackleSort tackleSort) {
        return tackleSortRepository.save(tackleSort);
    }

    //刪除器具類別
    @Override
    public void deleteTackleSort(Integer tackleSortId) {
        tackleSortRepository.deleteById(tackleSortId);
    }


}
