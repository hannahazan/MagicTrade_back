package org.MustacheTeam.MagicTrade.repository.catalog.cardname;

import org.MustacheTeam.MagicTrade.model.catalog.CardName;

import java.util.ArrayList;
import java.util.List;

public class JpaCardNameRepository implements CardNameRepository {

    SpringdataCardNameRepository repository;

    public JpaCardNameRepository(SpringdataCardNameRepository springdataCardNameRepository){
        this.repository= springdataCardNameRepository;
    }

    @Override
    public void save(List<String> cardNameToSave) {

        List<CardName> cardNameList = new ArrayList<>();
        cardNameToSave.forEach(cT -> cardNameList.add(new CardName(cT)));

        repository.saveAll(cardNameList);

    }

    @Override
    public List<String> getAllCardNames(){
        return repository.findAllCardNames();
    }
}
