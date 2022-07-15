package eeit45.group3.bakeyourlife.good.dao;

import eeit45.group3.bakeyourlife.good.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods,Integer> {

    Goods findGoodsByName(String name);

    Goods findGoodsById(Integer Id);

    List<Goods> findAllBySystem(String system);

    List<Goods> findAllByNameLike(String name);

   List<Goods> findBySystemOrderByAdmissionTimeDesc(String system);

   List<Goods> findByPackagematerialAndSystemOrderByAdmissionTimeDesc(String Packagematerial,String system);
}