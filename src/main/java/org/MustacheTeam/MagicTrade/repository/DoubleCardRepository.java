package org.MustacheTeam.MagicTrade.repository;

import org.MustacheTeam.MagicTrade.gateway.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.model.DoubleCard;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoubleCardRepository {

    void save(List<ScryfallCard> cardToSave);

    List<DoubleCard> getAllDoubleCards();

}
