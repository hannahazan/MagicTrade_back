package org.MustacheTeam.MagicTrade.corelogics.models;

import java.util.List;

public record Card(
        String id,
        String setId,
        String name,
        String manaCost,
        int cmc,
        String types,
        String text,
        String toughness,
        String power,
        String rarity,
        Boolean foil,
        Boolean fullArt,
        Boolean textLess,
        String cardMarketPrice,
        String standard,
        String pioneer,
        String explorer,
        String modern,
        String legacy,
        String pauper,
        String vintage,
        String commander,
        String brawl,
        String pauperCommander,
        String duel,
        String oldSchool,
        String imageSizeNormal,
        String imageSizeArtCrop,
        Boolean isDoubleCard,
        List<DoubleCard> doubleCards
) {
}
