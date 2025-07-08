package org.MustacheTeam.MagicTrade.repository.collection;

import org.MustacheTeam.MagicTrade.dto.CollectionDto;

import java.util.List;

public interface CollectionRepository {
    void save(List<CollectionDto> collectionDto);
}
