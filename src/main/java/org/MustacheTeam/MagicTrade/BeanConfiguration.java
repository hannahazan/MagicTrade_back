package org.MustacheTeam.MagicTrade;

import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.repository.card.JpaCardRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.cardType.JpaCardTypeRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.cardType.SpringDataCardTypeRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.creaturetype.JpaCreatureTypeRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.creaturetype.SpringDataCreatureTypeRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.power.JpaPowerRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.power.SpringDataPowerRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.landtype.JpaLandTypeRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.landtype.SpringDataLandTypeRepository;
import org.MustacheTeam.MagicTrade.repository.doublecard.JpaDoubleCardRepository;
import org.MustacheTeam.MagicTrade.repository.card.SpringDataCardRepository;
import org.MustacheTeam.MagicTrade.repository.doublecard.SpringDataDoubleCardRepository;
import org.MustacheTeam.MagicTrade.repository.set.JpaSetRepository;
import org.MustacheTeam.MagicTrade.repository.set.SpringDataSetRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

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

    @Bean
    public JpaSetRepository jpaSetRepository(SpringDataSetRepository springDataSetRepository){
        return new JpaSetRepository(springDataSetRepository);
    }

    @Bean
    public JpaCardTypeRepository jpaCardTypeRepository(SpringDataCardTypeRepository springDataCardTypeRepository){
        return new JpaCardTypeRepository(springDataCardTypeRepository);
    }

    @Bean
    public JpaCreatureTypeRepository jpaCreatureTypeRepository(SpringDataCreatureTypeRepository springDataCreatureTypeRepository){
        return new JpaCreatureTypeRepository(springDataCreatureTypeRepository);
    }

    @Bean
    public JpaLandTypeRepository jpaLandTypeRepository(SpringDataLandTypeRepository springDataLandTypeRepository){
        return  new JpaLandTypeRepository(springDataLandTypeRepository);
    }

    @Bean
    public JpaPowerRepository jpaPowerRepository(SpringDataPowerRepository springDataPowerRepository){
        return new JpaPowerRepository(springDataPowerRepository);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public RealScryfallGateway getRealScryfallGateway(){
        return new RealScryfallGateway(restTemplate());
    }


}
