package org.MustacheTeam.MagicTrade.controller;

import org.MustacheTeam.MagicTrade.model.Card;
import org.MustacheTeam.MagicTrade.service.card.GetAllCards;
import org.MustacheTeam.MagicTrade.service.card.RefreshCards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("magicTrade-api/cards")
public class CardController {

    @Autowired
    private RefreshCards refreshCards;

    @Autowired
    private GetAllCards getAllCards;


    @PostMapping
    public void refreshcard(){
        refreshCards.handle();
    }

    @GetMapping
    List<Card> getcards(){
        return getAllCards.handle();
    }


}
