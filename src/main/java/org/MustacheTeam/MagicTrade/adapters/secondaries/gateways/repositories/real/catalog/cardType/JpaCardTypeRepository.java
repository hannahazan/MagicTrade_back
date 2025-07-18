package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.cardType;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CardTypeRepository;

import java.util.ArrayList;
import java.util.List;

public class JpaCardTypeRepository implements CardTypeRepository {

    private final SpringDataCardTypeRepository repository;

    public JpaCardTypeRepository(SpringDataCardTypeRepository springDataCardTypeRepository) {
        this.repository = springDataCardTypeRepository;
    }

    @Override
    public List<String> getAllCardTypes() {
        return repository.findAllCardTypes();
    }

    @Override
    public void save(List<String> cardTypes) {
        ArrayList<CardTypeEntity> cardTypesList = new ArrayList<>();
        cardTypes.forEach(cardType -> cardTypesList.add(new CardTypeEntity(cardType)));
        repository.saveAll(cardTypesList);
    }
}