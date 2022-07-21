package eeit45.group3.bakeyourlife.good.service.impl;

import eeit45.group3.bakeyourlife.good.dao.GoodsRepository;
import eeit45.group3.bakeyourlife.good.model.Goods;
import eeit45.group3.bakeyourlife.good.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoodsServiceImpl implements GoodService {

    GoodsRepository goodsRepository;

    @Autowired
    public GoodsServiceImpl(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Override
    public Goods isDup(String name) {

        return goodsRepository.findGoodsByName(name);
    }
    @Transactional
    @Override
    public void save(Goods good) {
        goodsRepository.save(good);
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsRepository.findAll();
    }

    @Override
    public List<Goods> getAllBySystem(String system) {
        return goodsRepository.findAllBySystem(system);
    }

    @Override
    public List<Goods> getAllByNameLike(String name) {
        return goodsRepository.findAllByNameLike(name);
    }


    @Override
    public Goods getGoods(int pk) {
        return goodsRepository.findGoodsById(pk);
    }

    @Override
    @Transactional
    public void deleteGoods(Integer id) {
         goodsRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateGoods(Goods mb) {
         goodsRepository.save(mb);
    }

    @Override
    public List<Goods> findBySystemOrderByAdmissionTimeDesc(String system) {
        return goodsRepository.findBySystemOrderByAdmissionTimeDesc(system);
    }

    @Override
    public List<Goods> findByPackagematerialAndSystemOrderByAdmissionTimeDesc(String Packagematerial) {
        return goodsRepository.findByPackagematerialAndSystemOrderByAdmissionTimeDesc(Packagematerial,"上架中");
    }

    @Override
    public Long count() {
        return goodsRepository.count();
    }


    @Override
    public Goods max() {
        return goodsRepository.max();
    }

    @Override
    public Goods min() {
        return goodsRepository.min();
    }

    @Override
    public List<Goods> findGoodsSales() {
        return goodsRepository.findGoodsSales();
    }
}
