package org.MustacheTeam.MagicTrade.service.collection;

import org.MustacheTeam.MagicTrade.dto.CollectionDto;
import org.MustacheTeam.MagicTrade.repository.collection.JpaCollectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateCollection {
    private final JpaCollectionRepository repository;

    public CreateCollection(JpaCollectionRepository jpaCollectionRepository){
        this.repository = jpaCollectionRepository;
    }

    public void handle(List<CollectionDto> collectionToSave){
        repository.save(collectionToSave);
    }
}
