package org.MustacheTeam.MagicTrade.service.catalog.cardname;

import org.MustacheTeam.MagicTrade.dto.Filters;
import org.MustacheTeam.MagicTrade.repository.catalog.cardname.CardNameRepository;
import org.MustacheTeam.MagicTrade.repository.catalog.cardname.JpaCardNameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Filter;

@Service
public class GetAllCardNames {

    private final CardNameRepository repository;

    public GetAllCardNames(CardNameRepository cardNameRepository){
        this.repository = cardNameRepository;
    }

    public Filters handle(){
        List<String> cardNameJpa = repository.getAllCardNames();
        return new Filters(cardNameJpa);
    }


}
