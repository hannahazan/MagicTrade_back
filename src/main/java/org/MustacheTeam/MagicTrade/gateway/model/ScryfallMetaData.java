package org.MustacheTeam.MagicTrade.gateway.model;

import java.util.List;

public record ScryfallMetaData(
        String object,
        Integer total_cards,
        Boolean has_more,
        String next_page,
        List<ScryfallCard> data
) {
}
