package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;
import org.MustacheTeam.MagicTrade.corelogics.models.collection.CollectionCard;
import org.MustacheTeam.MagicTrade.corelogics.models.collection.CollectionItem;

import java.util.List;

public interface CollectionRepository {
    void save(CollectionItem collectionItem);
    List<CollectionCard> findByUserId(Long userId);
    void deleteByIdAndUserId(Long collectionId, Long userId);
}