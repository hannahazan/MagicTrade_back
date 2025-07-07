package org.MustacheTeam.MagicTrade.repository.collection;

import org.MustacheTeam.MagicTrade.dto.CollectionDto;
import org.MustacheTeam.MagicTrade.model.Collection;
import org.MustacheTeam.MagicTrade.repository.User.SpringDataUserRepository;
import org.MustacheTeam.MagicTrade.repository.card.SpringDataCardRepository;

import java.util.ArrayList;
import java.util.List;

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

    public void save(List<CollectionDto> collectionDto){
        List<Collection> collectionList = new ArrayList<>();
        collectionDto.forEach(collection->collectionList.add(new Collection(collection.userId(),collection.cardId(),collection.lang(),
        collection.state())));
    }

}
