package org.MustacheTeam.MagicTrade.service.catalog.cardname;

import org.MustacheTeam.MagicTrade.exception.ScryfallPersistenceException;
import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.repository.catalog.cardname.JpaCardNameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshCardNames {
    RealScryfallGateway realScryfallGateway;
    JpaCardNameRepository jpaCardNameRepository;

    public RefreshCardNames(RealScryfallGateway realScryfallGateway, JpaCardNameRepository jpaCardNameRepository){
        this.jpaCardNameRepository = jpaCardNameRepository;
        this.realScryfallGateway = realScryfallGateway;
    }

    public void handle(String catalogElementName){
        List<String> cardNames = realScryfallGateway.getScryfallCatalog(catalogElementName);
        try {
            jpaCardNameRepository.save(cardNames);
        } catch(Exception ex) {
            throw new ScryfallPersistenceException("Failed to persist Scryfall card names", ex);
        }
    }

}
