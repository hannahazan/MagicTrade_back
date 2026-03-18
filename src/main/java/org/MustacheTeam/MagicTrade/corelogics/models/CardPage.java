package org.MustacheTeam.MagicTrade.corelogics.models;

import java.util.List;

public record CardPage(
        List<Card> cards,
        Long count,
        String firstCursor,
        String nextCursor
) {
}
