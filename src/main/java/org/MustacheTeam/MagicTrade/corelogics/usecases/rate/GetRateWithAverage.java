package org.MustacheTeam.MagicTrade.corelogics.usecases.rate;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.RateRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.rate.RatedListWithAverage;

import java.util.List;

public class GetRateWithAverage {
    private final RateRepository rateRepository;

    public GetRateWithAverage(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public RatedListWithAverage handle(Long userRatedId) {
        return rateRepository.getRateWithAverageProjection(userRatedId);
    }
}
