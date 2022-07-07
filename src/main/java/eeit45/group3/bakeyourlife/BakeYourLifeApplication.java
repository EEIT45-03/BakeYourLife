package eeit45.group3.bakeyourlife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BakeYourLifeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BakeYourLifeApplication.class, args);

    }
    }


