package org.MustacheTeam.MagicTrade.corelogics.models.collection;

public record Collection(Long id,
           Long userId,
           String cardId,
           String lang,
           String state
){}
