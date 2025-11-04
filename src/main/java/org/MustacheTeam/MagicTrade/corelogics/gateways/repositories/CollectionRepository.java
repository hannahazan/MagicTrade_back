package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;
import org.MustacheTeam.MagicTrade.corelogics.models.collection.Collection;
import org.MustacheTeam.MagicTrade.corelogics.models.collection.CollectionCard;
import org.MustacheTeam.MagicTrade.corelogics.models.collection.CollectionUser;
import org.MustacheTeam.MagicTrade.corelogics.models.collection.CollectionUserList;

import java.util.List;

public interface CollectionRepository {
    void save(Collection collection, Long currentTraderId);
    List<CollectionCard> findByUserId(Long userId);
    void deleteByIdAndUserId(Long collectionId, Long userId);
    CollectionUserList getAllUsersAndCardsFromIdCard(String cardId);
}