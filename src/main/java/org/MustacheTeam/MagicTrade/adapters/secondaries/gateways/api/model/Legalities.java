package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model;

public record Legalities(
        String standard,
        String pioneer,
        String explorer,
        String modern,
        String legacy,
        String pauper,
        String vintage,
        String commander,
        String brawl,
        String paupercommander,
        String duel,
        String oldschool
) {
}
