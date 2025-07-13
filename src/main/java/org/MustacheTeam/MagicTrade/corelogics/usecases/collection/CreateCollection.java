package org.MustacheTeam.MagicTrade.corelogics.usecases.collection;

import org.MustacheTeam.MagicTrade.corelogics.models.CollectionDto;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.collection.JpaCollectionRepository;
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
