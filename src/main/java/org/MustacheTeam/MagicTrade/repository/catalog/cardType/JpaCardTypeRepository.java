package org.MustacheTeam.MagicTrade.repository.catalog.cardType;

import org.MustacheTeam.MagicTrade.model.catalog.CardType;

import java.util.ArrayList;
import java.util.List;

public class JpaCardTypeRepository implements CardTypeRepository {

    private final SpringDataCardTypeRepository repository;

    public JpaCardTypeRepository(SpringDataCardTypeRepository springDataCardTypeRepository) {
        this.repository = springDataCardTypeRepository;
    }

    public List<CardType> getAllCardTypes() {
        return repository.findAll();
    }

    public void save(List<String> cardTypes) {
        ArrayList<CardType> cardTypesList = new ArrayList<>();
        cardTypes.forEach(cardType -> cardTypesList.add(new CardType(cardType)));
        repository.saveAll(cardTypesList);
    }
}