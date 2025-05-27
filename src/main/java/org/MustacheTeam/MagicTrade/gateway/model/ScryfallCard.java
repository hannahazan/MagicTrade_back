package org.MustacheTeam.MagicTrade.gateway.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public record ScryfallCard(
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
        Prices purchase_uris,
        String cardMarket
) {


}

