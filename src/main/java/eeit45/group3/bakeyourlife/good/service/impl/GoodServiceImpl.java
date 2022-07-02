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
public class GoodServiceImpl implements GoodService {

    GoodsRepository repository;

    @Autowired
    public GoodServiceImpl(GoodsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Goods isDup(String name) {
        return repository.findByName(name);
    }

    @Override
    public int save(Goods good) {
        Goods goods = repository.save(good);
        return goods.getId();
    }

    @Override
    public List<Goods> getAllGoods() {
        return repository.findAll();
    }

    @Override
    public Goods getGoods(int pk) {
        return repository.findById(pk).orElse(null);
    }

    @Override
    public int deleteGoods(int ipk) {
        repository.deleteById(ipk);
        return 1;
    }

    @Override
    public int updateGoods(Goods mb) {
        repository.save(mb);
        return 1;
    }
}
