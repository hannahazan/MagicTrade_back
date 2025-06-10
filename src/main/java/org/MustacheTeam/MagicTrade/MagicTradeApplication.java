package org.MustacheTeam.MagicTrade;

import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MagicTradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagicTradeApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	@Bean
	public RealScryfallGateway getRealScryfallGateway(){
		return new RealScryfallGateway(getRestTemplate());
	}

}
