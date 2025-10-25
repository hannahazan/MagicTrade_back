package org.MustacheTeam.MagicTrade.corelogics.usecases.collection;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CollectionRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.collection.Collection;
import org.MustacheTeam.MagicTrade.corelogics.models.collection.CollectionItem;

public class CreateCollection {
    private final CollectionRepository repository;

    public CreateCollection(CollectionRepository repository) {
        this.repository = repository;
    }

    public void handle(Collection collection) {
        repository.save(collection);
    }
}