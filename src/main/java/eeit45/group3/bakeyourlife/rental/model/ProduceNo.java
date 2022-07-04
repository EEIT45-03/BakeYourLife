package eeit45.group3.bakeyourlife.rental.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;


@Entity

@Component
public class ProduceNo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    //器具ID (PK)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //器具名稱
    @Column(unique = true, nullable = false)
    private String name;

    //器具名稱
    @Column(nullable = false)
    private String date;

    //器具型號
    @Column(nullable = false)
    private Integer num;

    public ProduceNo(String name, String date, Integer num) {
        this.name = name;
        this.date = date;
        this.num = num;
    }

    public ProduceNo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}

