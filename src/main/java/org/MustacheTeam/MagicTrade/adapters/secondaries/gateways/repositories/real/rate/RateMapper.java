package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.rate;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.Utils;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.user.UserEntity;
import org.MustacheTeam.MagicTrade.corelogics.models.rate.Rate;
import org.MustacheTeam.MagicTrade.corelogics.models.rate.Rated;

public class RateMapper {
    private final Utils utils;

    public RateMapper(Utils utils) {
        this.utils = utils;
    }

    public RateEntity rateToRateEntity(Rate rate, Long raterId) {
        UserEntity userRated = utils.findUser(rate.userRatedId());
        UserEntity userRater = utils.findUser(raterId);
            return new RateEntity(
                    rate.rate(),
                    rate.message(),
                    userRated,
                    userRater
            );
    }

    public Rated rateEntityToRated(RateEntity rateEntity) {
        return new Rated(
                rateEntity.getId(),
                rateEntity.getRate(),
                rateEntity.getMessage(),
                rateEntity.getUserRated().getPseudo(),
                rateEntity.getUserRater().getPseudo()
        );
    }
}
