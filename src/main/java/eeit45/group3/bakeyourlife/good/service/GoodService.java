package eeit45.group3.bakeyourlife.good.service;

import eeit45.group3.bakeyourlife.good.model.Goods;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodService {
  Goods isDup(String name);

  void save(Goods good);

  List<Goods> getAllGoods();

  List<Goods> getAllBySystem(String system);

  List<Goods> getAllByNameLike(String name);

  Goods getGoods(int pk);

  void deleteGoods(Integer id);

  void updateGoods(Goods mb);

  List<Goods> findBySystemOrderByAdmissionTimeDesc(String system);

  List<Goods> findByPackagematerialAndSystemOrderByAdmissionTimeDesc(String Packagematerial);

  Long count();

  Goods max();

  Goods min();

  List<Goods> findGoodsSales();
}
