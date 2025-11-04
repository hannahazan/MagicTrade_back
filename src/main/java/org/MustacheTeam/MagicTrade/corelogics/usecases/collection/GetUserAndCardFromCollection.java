package org.MustacheTeam.MagicTrade.corelogics.usecases.collection;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.CollectionRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.collection.CollectionUserList;

public class GetUserAndCardFromCollection {
    private final CollectionRepository collectionRepository;

    public GetUserAndCardFromCollection( CollectionRepository collectionRepository){
        this.collectionRepository = collectionRepository;
    }

    public CollectionUserList handle(String cardId){
        return collectionRepository.getAllUsersAndCardsFromIdCard(cardId);
    }
}
