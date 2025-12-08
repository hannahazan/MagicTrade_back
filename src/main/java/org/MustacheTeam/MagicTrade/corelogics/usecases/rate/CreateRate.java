package org.MustacheTeam.MagicTrade.corelogics.usecases.rate;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.RateRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.rate.Rate;

public class CreateRate {
    private final RateRepository rateRepository;

    public CreateRate(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public void handle(Rate rate, Long userRaterId) {
        rateRepository.createRate(rate, userRaterId);
    }
}
