package org.MustacheTeam.MagicTrade.repository.collection;

import org.MustacheTeam.MagicTrade.dto.CollectionDto;
import org.MustacheTeam.MagicTrade.model.Card;
import org.MustacheTeam.MagicTrade.model.Collection;
import org.MustacheTeam.MagicTrade.model.User;
import org.MustacheTeam.MagicTrade.repository.User.SpringDataUserRepository;
import org.MustacheTeam.MagicTrade.repository.card.SpringDataCardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JpaCollectionRepository implements CollectionRepository{

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

        List<Collection> collectionList = new ArrayList<>();

        for (CollectionDto c : collectionDtoList) {
            User user = springDataUserRepository.findById(c.userId())
                    .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + c.userId()));

            Card card = springDataCardRepository.findById(c.cardId())
                    .orElseThrow(() -> new IllegalArgumentException("Card not found with id: " + c.cardId()));

            collectionList.add(new Collection(user, card, c.lang(), c.state()));
        }

        repository.saveAll(collectionList);
    }
}
