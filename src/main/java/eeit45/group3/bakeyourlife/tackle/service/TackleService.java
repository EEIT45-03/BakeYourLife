package eeit45.group3.bakeyourlife.tackle.service;

import eeit45.group3.bakeyourlife.tackle.model.Tackle;

import java.util.List;

public interface TackleService {

    //查詢全部的器具
    public List<Tackle> findAllTackle();
    //查詢全部的器具名稱
    public List<String> findAllTackleName();

    //依器具ID查詢器具
    public Tackle findByTackleId(Integer tackleId);

    //依器具名稱查詢器具
    public Tackle findByTackleName(String tackleName);

    //新增器具
    public Tackle createTackle(Tackle tackle);

    //更新器具
    public Tackle updateTackle(Tackle tackle);

    //刪除器具
    public void deleteTackle(Integer tackleId);
}
