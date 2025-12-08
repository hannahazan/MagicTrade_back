package org.MustacheTeam.MagicTrade.corelogics.models.rate;

import java.util.List;

public record RatedListWithAverage(List<Rated> ratedList, RatedAverage average) {
}
