package eeit45.group3.bakeyourlife.tackle.service.impl;

import eeit45.group3.bakeyourlife.tackle.dao.TackleRepository;
import eeit45.group3.bakeyourlife.tackle.model.Tackle;
import eeit45.group3.bakeyourlife.tackle.service.TackleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TackleServiceImpl implements TackleService {

    private TackleRepository tackleRepository;

    @Autowired
    public TackleServiceImpl(TackleRepository tackleRepository) {
        this.tackleRepository = tackleRepository;
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
}
