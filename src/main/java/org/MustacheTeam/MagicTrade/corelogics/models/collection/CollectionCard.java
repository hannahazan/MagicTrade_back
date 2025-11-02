package org.MustacheTeam.MagicTrade.corelogics.models.collection;

import java.util.List;

public record CollectionCard(
        Long id,
        Long userId,
        String cardId,
        String lang,
        String state,
        String imageUrl,
        Boolean isDoubleCard,
        List<CollectionDoubleCard> doubleCards
) {}
