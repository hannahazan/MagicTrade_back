package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.doublecard.DoubleCardEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoubleCardRepository {
    void save(List<ScryfallCard> cardToSave);
    List<DoubleCardEntity> getAllDoubleCards();
}
