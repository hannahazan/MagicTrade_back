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

    public void save(List<CollectionDto> collectionDto){

        List<Collection> collectionList = new ArrayList<>();

        collectionDto.forEach(c ->{
            collectionList.add(new Collection(springDataUserRepository.findUserById(c.userId()),springDataCardRepository.findCardById(c.cardId()),
                    c.lang(), c.state()));
        } );
        repository.saveAll(collectionList);
    }
}
