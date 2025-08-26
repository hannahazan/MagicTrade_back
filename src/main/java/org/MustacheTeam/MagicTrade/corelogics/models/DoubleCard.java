package org.MustacheTeam.MagicTrade.corelogics.models;

public record DoubleCard(
        Long id,
        String cardId,
        String name,
        String manaCost,
        String typeLine,
        String text,
        String power,
        String toughness,
        String imageSizeNormal,
        String imageSizeArtCrop
) {
}
