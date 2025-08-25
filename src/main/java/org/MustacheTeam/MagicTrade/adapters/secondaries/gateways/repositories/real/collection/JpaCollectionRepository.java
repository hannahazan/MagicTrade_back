package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CollectionRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Collection;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.card.CardEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.UserEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.SpringDataUserRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.card.SpringDataCardRepository;

import java.util.ArrayList;
import java.util.List;

public class JpaCollectionRepository implements CollectionRepository {

    private final SpringDataCollectionRepository repository;
    private final SpringDataUserRepository springDataUserRepository;
    private final SpringDataCardRepository springDataCardRepository;

    public JpaCollectionRepository(SpringDataCollectionRepository springDataCollectionRepository,SpringDataCardRepository springDataCardRepository,
                                   SpringDataUserRepository springDataUserRepository){
        this.repository = springDataCollectionRepository;
        this.springDataCardRepository = springDataCardRepository;
        this.springDataUserRepository = springDataUserRepository;

    }

    public void save(List<Collection> collectionDtoList) {

        List<CollectionEntity> collectionList = new ArrayList<>();

        for (Collection c : collectionDtoList) {
            UserEntity user = springDataUserRepository.findById(c.userId())
                    .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + c.userId()));

            CardEntity card = springDataCardRepository.findById(c.cardId())
                    .orElseThrow(() -> new IllegalArgumentException("Card not found with id: " + c.cardId()));

            collectionList.add(new CollectionEntity(user, card, c.lang(), c.state()));
        }

        repository.saveAll(collectionList);
    }
}
