package eeit45.group3.bakeyourlife.rental.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Component
public class ProduceNo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(columnDefinition = "varchar(15) not null")
    private String tableName;

    @Column(columnDefinition = "varchar(15) not null")
    private String date;

    @Column(columnDefinition = "int not null")
    private Integer number;


    public ProduceNo() {
    }

    public ProduceNo(Integer id, String tableName, String date, Integer number) {
        Id = id;
        this.tableName = tableName;
        this.date = date;
        this.number = number;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
