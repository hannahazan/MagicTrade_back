package org.MustacheTeam.MagicTrade.corelogics.usecases.doublecard;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.doublecard.DoubleCardEntity;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.DoubleCardRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.DoubleCard;
import org.MustacheTeam.MagicTrade.corelogics.models.DoubleCardList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllDoubleCards {

    private final DoubleCardRepository repository;

    public GetAllDoubleCards(DoubleCardRepository doubleCardRepository){
        this.repository = doubleCardRepository;
    }

    public DoubleCardList handle(){
        return repository.getAllDoubleCards();
    }
}
