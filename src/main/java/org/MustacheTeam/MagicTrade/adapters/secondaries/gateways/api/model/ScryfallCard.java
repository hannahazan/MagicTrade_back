package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public record ScryfallCard(
        String id,
        @JsonProperty("set_id")
        String setId,
        String name,
        @JsonProperty("mana_cost")
        String manaCost,
        int cmc,
        @JsonProperty("type_line")
        String types,
        @JsonProperty("oracle_text")
        String text,
        String toughness,
        String  power,
        String rarity,
        Boolean foil,
        @JsonProperty("full_art")
        Boolean fullArt,
        @JsonProperty("textless")
        Boolean textLess,
        Prices purchase_uris,
        Legalities legalities,
        ArrayList games,
        Illustrations image_uris,
        ArrayList<doubleCard> card_faces
) {


}

