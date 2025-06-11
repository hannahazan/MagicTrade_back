package org.MustacheTeam.MagicTrade.service.cardType;

import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.repository.cardType.JpaCardTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshCardTypes {
    RealScryfallGateway realScryfallGateway;
    JpaCardTypeRepository repository;

    public RefreshCardTypes(RealScryfallGateway realScryfallGateway, JpaCardTypeRepository jpaCardTypeRepository){
        this.realScryfallGateway = realScryfallGateway;
        this.repository = jpaCardTypeRepository;
    }

    public void handle(){
        List<String> cardTypes = realScryfallGateway.getScryfallCatalog("card-types");
        if (cardTypes == null || cardTypes.isEmpty()) {
            throw new RuntimeException("Scryfall card types not found");
        }
        repository.save(cardTypes);
    }
}
