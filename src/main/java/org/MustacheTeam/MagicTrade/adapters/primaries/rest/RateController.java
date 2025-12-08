package org.MustacheTeam.MagicTrade.adapters.primaries.rest;

import org.MustacheTeam.MagicTrade.adapters.security.CurrentTrader;
import org.MustacheTeam.MagicTrade.corelogics.models.rate.Rate;
import org.MustacheTeam.MagicTrade.corelogics.models.rate.RatedAverage;
import org.MustacheTeam.MagicTrade.corelogics.models.rate.RatedListWithAverage;
import org.MustacheTeam.MagicTrade.corelogics.usecases.rate.CreateRate;
import org.MustacheTeam.MagicTrade.corelogics.usecases.rate.GetRateWithAverage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("magicTrade-api/rate")
public class RateController {

    @Autowired
    CreateRate createRate;

    @Autowired
    GetRateWithAverage getRateWithAverage;

    @PostMapping
    public void create(@RequestBody Rate rate, @AuthenticationPrincipal CurrentTrader raterId){
        createRate.handle(rate, raterId.getId());
    }

    @GetMapping("/rateAndAverage")
    public RatedListWithAverage getRateWithAverage(@RequestParam(name = "ratedId") Long userRatedId){
        return getRateWithAverage.handle(userRatedId);
    }

}
