package org.MustacheTeam.MagicTrade.corelogics.usecases.catalog.cardType;

import org.MustacheTeam.MagicTrade.corelogics.models.Filters;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CardTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCardTypes {

    private final CardTypeRepository repository;

    public GetAllCardTypes(CardTypeRepository cardTypeRepository) {

        this.repository = cardTypeRepository;
    }

    public Filters handle() {
        List<String> cardTypesJpa = repository.getAllCardTypes();
        return new Filters(cardTypesJpa) ;
    }
}
