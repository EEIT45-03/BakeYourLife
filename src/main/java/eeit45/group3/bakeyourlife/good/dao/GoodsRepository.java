package eeit45.group3.bakeyourlife.good.dao;

import eeit45.group3.bakeyourlife.good.model.Goods;
import eeit45.group3.bakeyourlife.good.utils.GoodsCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods,Integer> {

    Goods findGoodsByName(String name);

    Goods findGoodsById(Integer Id);

    List<Goods> findAllBySystem(String system);

    List<Goods> findAllByNameLike(String name);

   List<Goods> findBySystemOrderByAdmissionTimeDesc(String system);

   List<Goods> findByPackagematerialAndSystemOrderByAdmissionTimeDesc(String Packagematerial,String system);

    @Query(nativeQuery = true, value = "Select packagematerial AS 'label', count(packagematerial) AS 'value' from member_goods_table3 group by packagematerial")
    List<GoodsCount> findGoodsTypeAmount();

    @Query(nativeQuery = true, value = "Select origin AS 'label', count(origin) AS 'value' from member_goods_table3 group by origin")
    List<GoodsCount> findGoodsOriginAmount();

}