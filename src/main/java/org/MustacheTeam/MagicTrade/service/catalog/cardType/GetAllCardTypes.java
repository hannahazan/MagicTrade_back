package org.MustacheTeam.MagicTrade.service.catalog.cardType;

import org.MustacheTeam.MagicTrade.dto.Filters;
import org.MustacheTeam.MagicTrade.model.catalog.CardType;
import org.MustacheTeam.MagicTrade.repository.catalog.cardType.CardTypeRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.cardType.JpaCardTypeRepository;
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
