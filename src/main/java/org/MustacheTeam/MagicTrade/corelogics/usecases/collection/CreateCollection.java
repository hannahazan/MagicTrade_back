package org.MustacheTeam.MagicTrade.corelogics.usecases.collection;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CollectionRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.Collection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateCollection {
    private final CollectionRepository repository;

    public CreateCollection(CollectionRepository collectionRepository){
        this.repository = collectionRepository;
    }

    public void handle(List<Collection> collectionToSave){
        repository.save(collectionToSave);
    }
}
