package org.MustacheTeam.MagicTrade.corelogics.models.rate;

public record Rate(Integer rate,
                   String message,
                   Long userRatedId,
                   Long tradeId) {
}
