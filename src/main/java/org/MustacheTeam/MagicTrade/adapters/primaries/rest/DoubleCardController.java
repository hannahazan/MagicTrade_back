package org.MustacheTeam.MagicTrade.adapters.primaries.rest;

import org.MustacheTeam.MagicTrade.corelogics.models.DoubleCardList;
import org.MustacheTeam.MagicTrade.corelogics.usecases.doublecard.GetAllDoubleCards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/magicTrade-api/double-cards")
public class DoubleCardController {

    @Autowired
    GetAllDoubleCards getAllDoubleCards;

    @GetMapping
    public DoubleCardList getAllCards(){
        return getAllDoubleCards.handle();
    }

}

