package org.MustacheTeam.MagicTrade.corelogics.usecases.collection;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CollectionRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.collection.Collection;

public class CreateCollection {
    private final CollectionRepository repository;

    public CreateCollection(CollectionRepository repository) {
        this.repository = repository;
    }

    public void handle(Collection collection, Long currentTraderId ) {
        repository.save(collection, currentTraderId);
    }
}