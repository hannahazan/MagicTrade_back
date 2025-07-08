package org.MustacheTeam.MagicTrade.service.card;

import org.MustacheTeam.MagicTrade.model.Card;
import org.MustacheTeam.MagicTrade.repository.card.JpaCardRepository;

public class GetCardById {
    private final JpaCardRepository repository;

    public GetCardById(JpaCardRepository jpaCardRepository){
        this.repository = jpaCardRepository;
    }

    public Card handle(String id){
        return repository.getCardById(id);
    }
}
