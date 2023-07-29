package eeit45.group3.bakeyourlife;

import eeit45.group3.bakeyourlife.order.model.Cart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class)
@EnableAsync
// @EnableCaching
public class BakeYourLifeApplication {

  public static void main(String[] args) {
    SpringApplication.run(BakeYourLifeApplication.class, args);
  }

  @Bean
  RedisTemplate<String, Cart> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    final RedisTemplate<String, Cart> template = new RedisTemplate<>();
    template.setConnectionFactory(redisConnectionFactory);
    template.setKeySerializer(new StringRedisSerializer());
    template.setHashValueSerializer(new GenericToStringSerializer<>(Cart.class));
    template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Cart.class));
    return template;
  }
}
