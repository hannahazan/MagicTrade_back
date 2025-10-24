package org.MustacheTeam.MagicTrade.corelogics.usecases.collection;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CollectionRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.collection.CollectionCard;

import java.util.List;

public class GetCollection {
    private final CollectionRepository repository;

    public GetCollection(CollectionRepository repository) {
        this.repository = repository;
    }

    public List<CollectionCard> handle(Long userId) {
        return repository.findByUserId(userId);
    }
}
