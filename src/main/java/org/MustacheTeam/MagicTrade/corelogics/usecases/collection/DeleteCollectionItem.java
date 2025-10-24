package org.MustacheTeam.MagicTrade.corelogics.usecases.collection;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CollectionRepository;

public class DeleteCollectionItem {
    private final CollectionRepository repository;

    public DeleteCollectionItem(CollectionRepository repository) {
        this.repository = repository;
    }

    public void handle(Long collectionId, Long userId) {
        repository.deleteByIdAndUserId(collectionId, userId);
    }
}
