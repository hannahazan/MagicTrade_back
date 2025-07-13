package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.collection;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CollectionRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.CollectionDto;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.card.CardEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.User.UserEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.User.SpringDataUserRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.card.SpringDataCardRepository;

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

    public void save(List<CollectionDto> collectionDtoList) {

        List<CollectionEntity> collectionList = new ArrayList<>();

        for (CollectionDto c : collectionDtoList) {
            UserEntity user = springDataUserRepository.findById(c.userId())
                    .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + c.userId()));

            CardEntity card = springDataCardRepository.findById(c.cardId())
                    .orElseThrow(() -> new IllegalArgumentException("Card not found with id: " + c.cardId()));

            collectionList.add(new CollectionEntity(user, card, c.lang(), c.state()));
        }

        repository.saveAll(collectionList);
    }
}
