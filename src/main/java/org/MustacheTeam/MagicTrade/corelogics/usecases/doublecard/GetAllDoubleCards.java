package org.MustacheTeam.MagicTrade.corelogics.usecases.doublecard;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.doublecard.DoubleCardEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.doublecard.JpaDoubleCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllDoubleCards {

    private final JpaDoubleCardRepository JpaDoubleCardRepository;

    public GetAllDoubleCards(JpaDoubleCardRepository jpaDoubleCardRepository){
        this.JpaDoubleCardRepository = jpaDoubleCardRepository;
    }

    public List<DoubleCardEntity> handle(){
        return JpaDoubleCardRepository.getAllDoubleCards();
    }
}
