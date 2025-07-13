package org.MustacheTeam.MagicTrade.corelogics.usecases.card;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.card.CardEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.card.JpaCardRepository;

public class GetCardById {
    private final JpaCardRepository repository;

    public GetCardById(JpaCardRepository jpaCardRepository){
        this.repository = jpaCardRepository;
    }

    public CardEntity handle(String id){
        return repository.getCardById(id);
    }
}
