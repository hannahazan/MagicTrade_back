package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.corelogics.models.Collection;

import java.util.List;

public interface CollectionRepository {
    void save(List<Collection> collectionDto);
}
