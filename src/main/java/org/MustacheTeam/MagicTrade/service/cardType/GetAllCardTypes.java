package org.MustacheTeam.MagicTrade.service.cardType;

import org.MustacheTeam.MagicTrade.model.CardType;
import org.MustacheTeam.MagicTrade.repository.cardType.JpaCardTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCardTypes {

    private final JpaCardTypeRepository repository;

    public GetAllCardTypes(JpaCardTypeRepository jpaCardTypeRepository) {
        this.repository = jpaCardTypeRepository;
    }

    public List<CardType> handle() {
        return repository.getAllCardTypes();
    }
}
