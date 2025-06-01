package org.MustacheTeam.MagicTrade.repository;

import org.MustacheTeam.MagicTrade.gateway.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.model.Card;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository {

    void save(List<ScryfallCard> cardToSave);

    List<Card> getAllCards();
}
