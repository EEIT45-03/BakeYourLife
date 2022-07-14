package eeit45.group3.bakeyourlife.rental.model;

import eeit45.group3.bakeyourlife.tackle.model.Tackle;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "TackleBag")
@Component
public class TackleBag implements Serializable {

    private static final long serialVersionUID = 1L;

    //器具清單ID (PK)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tackleBagId;

    //數量
    @Column(name = "quantity",columnDefinition = "int not null")
    private Integer quantity;

    //小計
    @Column(name = "price",columnDefinition = "int not null")
    private Integer price;

    //租借器具
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="FK_tackleId", referencedColumnName = "tackleId", nullable = false)
    private Tackle tackle;

    //器具租借清單
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="FK_tackleListId", referencedColumnName = "tackleListId", nullable = false)
    private TackleList tackleList;

    public TackleBag() {
    }

    public TackleBag(TackleList tackleList) {
        this.tackleList = tackleList;
    }

    public TackleBag(Integer quantity, Integer price, Tackle tackle, TackleList tackleList) {
        this.quantity = quantity;
        this.price = price;
        this.tackle = tackle;
        this.tackleList = tackleList;
    }

    public Integer getTackleBagId() {
        return tackleBagId;
    }

    public void setTackleBagId(Integer tackleBagId) {
        this.tackleBagId = tackleBagId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Tackle getTackle() {
        return tackle;
    }

    public void setTackle(Tackle tackle) {
        this.tackle = tackle;
    }

    public TackleList getTackleList() {
        return tackleList;
    }

    public void setTackleList(TackleList tackleList) {
        this.tackleList = tackleList;
    }

}
