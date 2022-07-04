package eeit45.group3.bakeyourlife.good.dao;

import eeit45.group3.bakeyourlife.good.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods,Integer> {

    Goods findGoodsByName(String name);

    Goods findGoodsById(Integer Id);
}
