package eeit45.group3.bakeyourlife.good.service;

import java.util.List;


import eeit45.group3.bakeyourlife.good.model.Goods;

public interface GoodService {
	Goods isDup(String name);

	int save(Goods good);

	List<Goods> getAllGoods();

	Goods getGoods(int pk);

	int deleteGoods(int ipk);

	int updateGoods(Goods mb);
}
