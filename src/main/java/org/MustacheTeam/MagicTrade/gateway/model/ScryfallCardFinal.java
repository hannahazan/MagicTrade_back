package org.MustacheTeam.MagicTrade.gateway.model;

import jakarta.validation.Valid;

public record ScryfallCardFinal(
        String id,
        String set_id,
        String name,
        String mana_cost,
        int cmc,
        String type_line,
        String oracle_text,
        String rarity,
        Boolean foil,
        Boolean full_art,
        Boolean textless,
        String cardMarketPrice
) {


}
