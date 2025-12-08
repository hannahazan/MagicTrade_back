package org.MustacheTeam.MagicTrade.corelogics.models.rate;

public record Rated(Long id,
                    Integer rate,
                    String message,
                    String userRatedPseudo,
                    String userRaterPseudo) {
}
