package eeit45.group3.bakeyourlife.tackle.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "TackleSort")
@Component
public class TackleSort implements Serializable {

    private static final long serialVersionUID = 1L;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tackleSortId;

    @Column(nullable = false, unique = true)
    private String sort;

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = false, mappedBy = "tackleSort")
    private Set<Tackle> tackles = new LinkedHashSet<Tackle>();

    public TackleSort() {
    }

    public TackleSort(String sort) {
        this.sort = sort;
    }

    public Integer getTackleSortId() {
        return tackleSortId;
    }

    public void setTackleSortId(Integer tackleSortId) {
        this.tackleSortId = tackleSortId;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
