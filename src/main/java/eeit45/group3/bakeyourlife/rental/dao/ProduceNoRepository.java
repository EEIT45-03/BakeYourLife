package eeit45.group3.bakeyourlife.rental.dao;

import eeit45.group3.bakeyourlife.rental.model.ProduceNo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduceNoRepository extends JpaRepository<ProduceNo, Integer> {
    public ProduceNo findByName(String name);
}
