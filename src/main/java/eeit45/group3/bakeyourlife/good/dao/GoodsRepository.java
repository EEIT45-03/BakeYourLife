package eeit45.group3.bakeyourlife.good.dao;

import eeit45.group3.bakeyourlife.good.model.Goods;
import eeit45.group3.bakeyourlife.good.utils.GoodsCount;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GoodsRepository extends JpaRepository<Goods, Integer> {

  Goods findGoodsByName(String name);

  Goods findGoodsById(Integer Id);

  List<Goods> findAllBySystem(String system);

  List<Goods> findAllByNameLike(String name);

  List<Goods> findBySystemOrderByAdmissionTimeDesc(String system);

  List<Goods> findByPackagematerialAndSystemOrderByAdmissionTimeDesc(
      String Packagematerial, String system);

  @Query(
      nativeQuery = true,
      value =
          "Select packagematerial AS 'label', count(packagematerial) AS 'value' from member_goods_table3 group by packagematerial")
  List<GoodsCount> findGoodsTypeAmount();

  @Query(
      nativeQuery = true,
      value =
          "Select origin AS 'label', count(origin) AS 'value'  from member_goods_table3  where packagematerial='麵粉' group by origin ")
  List<GoodsCount> findGoodsOriginAmount();

  @Query(
      nativeQuery = true,
      value =
          "select packagematerial AS 'label',sum(cast(count as int))AS 'Value' from member_goods_table3 GROUP BY packagematerial")
  List<GoodsCount> findGoodsNameCount();

  @Query(
      nativeQuery = true,
      value =
          "select * from member_goods_table3 where packages\n"
              + "= (select max(cast(packages as int)) from member_goods_table3 ) ")
  Goods max();

  @Query(
      nativeQuery = true,
      value =
          "select * from member_goods_table3 where packages\n"
              + "= (select min(cast(packages as int)) from member_goods_table3 ) ")
  Goods min();

  @Query(
      nativeQuery = true,
      value = "select * from member_goods_table3 where sales = '是' and system = '上架中'")
  List<Goods> findGoodsSales();
}
