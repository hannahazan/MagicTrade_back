package org.MustacheTeam.MagicTrade.corelogics.gateways.repositories;

import org.MustacheTeam.MagicTrade.corelogics.models.rate.Rate;
import org.MustacheTeam.MagicTrade.corelogics.models.rate.RatedAverage;
import org.MustacheTeam.MagicTrade.corelogics.models.rate.RatedListWithAverage;

import java.util.List;

public interface RateRepository {
    //RatedList getAllRatesOfOneRated();
    void createRate(Rate rate, Long userRaterId);
    RatedListWithAverage getRateWithAverageProjection(Long userRatedId);

}
