package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.inmemory;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.doublecard.DoubleCardEntity;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.DoubleCardRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.DoubleCard;
import org.MustacheTeam.MagicTrade.corelogics.models.DoubleCardList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class InMemoryDoublecardRepository implements DoubleCardRepository {

    List<DoubleCard> doubleCardList = new ArrayList<>();

    @Override
    public DoubleCardList  getAllDoubleCards(){
        return new DoubleCardList(doubleCardList);

    }

    public void feedDoubleCardList(List<DoubleCard> doubleCards){
        doubleCardList.addAll(doubleCards);
    }
}
