package org.MustacheTeam.MagicTrade.corelogics.models.collection;

public record CollectionItem(
        Long id,
        Long userId,
        String cardId,
        String lang,
        String state
) {}

