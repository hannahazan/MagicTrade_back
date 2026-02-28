package org.MustacheTeam.MagicTrade.corelogics.models;

public record CardPage(
        CardList cards,
        Long count,
        String firstCursor,
        String nextCursor
) {
}
