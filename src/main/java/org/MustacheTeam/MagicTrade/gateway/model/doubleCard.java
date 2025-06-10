package org.MustacheTeam.MagicTrade.gateway.model;

public record doubleCard(
        String cardId,
        String name,
        String mana_cost,
        String type_line,
        String oracle_text,
        String power,
        String toughness,
        Illustrations image_uris
) {
}
