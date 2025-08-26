package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.doublecard.DoubleCardEntity;
import org.MustacheTeam.MagicTrade.corelogics.models.DoubleCardList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoubleCardRepository {
    DoubleCardList  getAllDoubleCards();
}
