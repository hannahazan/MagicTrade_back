package org.MustacheTeam.MagicTrade.service;

import org.MustacheTeam.MagicTrade.gateway.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.repository.JpaCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefreshCards {

    private final RealScryfallGateway realScryfallGateway;
    private final JpaCardRepository jpaCardRepository;

    public RefreshCards(RealScryfallGateway realScryfallGateway,JpaCardRepository cardRepository){
        this.realScryfallGateway = realScryfallGateway;
        this.jpaCardRepository = cardRepository;
    }

    public void handle(){
        List<ScryfallCard> cards = realScryfallGateway.getScryfallCardsTest();
        jpaCardRepository.save(cards);
    }

}
