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
    public Goods getGoods(int pk) {
        return goodsRepository.findGoodsById(pk);
    }

    @Override
    @Transactional
    public void deleteGoods(int ipk) {
         goodsRepository.deleteById(ipk);
    }

    @Override
    @Transactional
    public void updateGoods(Goods mb) {
         goodsRepository.save(mb);
    }
}