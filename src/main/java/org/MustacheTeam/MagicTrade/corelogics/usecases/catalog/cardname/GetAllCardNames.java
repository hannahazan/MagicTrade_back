package org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.cardname;

import org.MustacheTeam.MagicTrade.corelogics.models.Filters;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CardNameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCardNames {

    private final CardNameRepository repository;

    public GetAllCardNames(CardNameRepository cardNameRepository){
        this.repository = cardNameRepository;
    }

    public Filters handle(){
        return repository.getAllCardNames();
    }

}
