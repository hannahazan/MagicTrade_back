package org.MustacheTeam.MagicTrade.service.catalog.cardType;

import org.MustacheTeam.MagicTrade.model.catalog.CardType;
import org.MustacheTeam.MagicTrade.repository.catalog.cardType.JpaCardTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCardTypes {

    private final JpaCardTypeRepository repository;

    public GetAllCardTypes(JpaCardTypeRepository jpaCardTypeRepository) {
        this.repository = jpaCardTypeRepository;
    }

    public List<String> handle() {
        return repository.getAllCardTypes();
    }
}
