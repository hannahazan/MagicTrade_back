package org.MustacheTeam.MagicTrade.adapters.primaries.rest;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.doublecard.DoubleCardEntity;
import org.MustacheTeam.MagicTrade.corelogics.models.DoubleCardList;
import org.MustacheTeam.MagicTrade.corelogics.usecases.doublecard.GetAllDoubleCards;
import org.MustacheTeam.MagicTrade.corelogics.usecases.doublecard.RefreshDoubleCards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/magicTrade-api/double-cards")
public class DoubleCardController {

    @Autowired
    RefreshDoubleCards refreshDoubleCards;

    @Autowired
    GetAllDoubleCards getAllDoubleCards;

    @PostMapping
    public void refresh(){
        refreshDoubleCards.handle();
    }

    @GetMapping
    public DoubleCardList getAllCards(){
        return getAllDoubleCards.handle();
    }


}

