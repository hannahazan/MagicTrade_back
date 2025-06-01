package org.MustacheTeam.MagicTrade;

import org.MustacheTeam.MagicTrade.repository.JpaCardRepository;
import org.MustacheTeam.MagicTrade.repository.JpaDoubleCardRepository;
import org.MustacheTeam.MagicTrade.repository.SpringDataCardRepository;
import org.MustacheTeam.MagicTrade.repository.SpringDataDoubleCardRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"org.MustacheTeam.MagicTrade"})
@EnableJpaRepositories(basePackages = {"org.MustacheTeam.MagicTrade"})
public class BeanConfiguration {

    @Bean
    public JpaCardRepository jpaCardRepository(SpringDataCardRepository springDataCardRepository){
        return new JpaCardRepository(springDataCardRepository);
    }

    @Bean
    public JpaDoubleCardRepository jpaDoubleCardRepository(SpringDataDoubleCardRepository springDataDoubleCardRepository){
        return new JpaDoubleCardRepository(springDataDoubleCardRepository);
    }

}
