package org.MustacheTeam.MagicTrade.corelogics.models.collection;

public record CollectionUser(
        Long id,
        String cardId,
        String lang,
        String state,
        Long userId,
        String pseudo,
        String city,
        String country,
        String department
) {
}
