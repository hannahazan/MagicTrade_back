package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.cardname;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CardNameRepository;

import java.util.ArrayList;
import java.util.List;

public class JpaCardNameRepository implements CardNameRepository {

    SpringdataCardNameRepository repository;

    public JpaCardNameRepository(SpringdataCardNameRepository springdataCardNameRepository){
        this.repository= springdataCardNameRepository;
    }

    @Override
    public void save(List<String> cardNameToSave) {

        List<CardNameEntity> cardNameList = new ArrayList<>();
        cardNameToSave.forEach(cT -> cardNameList.add(new CardNameEntity(cT)));

        repository.saveAll(cardNameList);

    }

    @Override
    public List<String> getAllCardNames(){
        return repository.findAllCardNames();
    }
}
