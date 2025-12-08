package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.rate;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.Utils;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.TradeEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.TradeMapper;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.RateRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.rate.Rate;
import org.MustacheTeam.MagicTrade.corelogics.models.rate.Rated;
import org.MustacheTeam.MagicTrade.corelogics.models.rate.RatedAverage;
import org.MustacheTeam.MagicTrade.corelogics.models.rate.RatedListWithAverage;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.Trade;
import org.MustacheTeam.MagicTrade.corelogics.utils.RateRules;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

public class JpaRateRepository extends RateRules implements RateRepository {
    private final SpringDataRateRepository repository;
    private final RateMapper rateMapper;
    private final Utils utils;
    private final TradeMapper tradeMapper;

    public JpaRateRepository(SpringDataRateRepository repository, RateMapper rateMapper, Utils utils, TradeMapper  tradeMapper) {
        this.repository = repository;
        this.rateMapper = rateMapper;
        this.utils = utils;
        this.tradeMapper = tradeMapper;
    }

    @Override
    public void createRate(Rate rate, Long raterId) {
        TradeEntity tradeEntity = utils.getOneTrade(rate.tradeId());
        Trade trade = tradeMapper.tradeEntityToTrade(tradeEntity);
        boolean allParticipants = areAllParticipantsOfTheTrade(raterId,rate.userRatedId(), trade);
        boolean closedTrade = isTradeClosed(trade);

        if(allParticipants && closedTrade){
            RateEntity rateEntity = rateMapper.rateToRateEntity(rate, raterId);
            repository.save(rateEntity);
        }
        else{
            throw new RuntimeException("trade not closed or not the rights participants");
        }

    }

    @Override
    public RatedListWithAverage getRateWithAverageProjection(Long userRatedId) {
        Double Average = repository.findAvgRate(userRatedId);
        List<RateEntity> rates = repository.findByUserRatedId(userRatedId);
        List<Rated> ratedList = new ArrayList();

        rates.forEach(rate -> {
            ratedList.add(rateMapper.rateEntityToRated(rate));
        });

        return new RatedListWithAverage(ratedList, new RatedAverage(Average));
    }
}
