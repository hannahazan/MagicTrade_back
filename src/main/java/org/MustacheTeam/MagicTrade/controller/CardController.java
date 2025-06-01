package org.MustacheTeam.MagicTrade.controller;

import org.MustacheTeam.MagicTrade.gateway.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.gateway.model.ScryfallOnlyPaperCard;
import org.MustacheTeam.MagicTrade.gateway.model.doubleCard;
import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.model.Card;
import org.MustacheTeam.MagicTrade.service.GetAllCards;
import org.MustacheTeam.MagicTrade.service.RefreshCards;
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
    private RealScryfallGateway realScryfallGateway;

    @Autowired
    private RefreshCards refreshCards;

    @Autowired
    private GetAllCards getAllCards;

    @GetMapping
    public List<ScryfallOnlyPaperCard> getAllCards(){
        return realScryfallGateway.getScryfallCards();
    }

    @GetMapping(value = "/test")
    public List<ScryfallCard> getAllCardsTest(){return realScryfallGateway.getScryfallCardsTest();}

    @GetMapping(value = "/test2")
    public List<doubleCard> getAllCardsTest2(){
        return realScryfallGateway.getScryfallDoubleCards();
    }

    @PostMapping
    public void refreshcard(){
        refreshCards.handle();
    }

    @GetMapping(value = "/cards")
    List<Card> getcards(){
        return getAllCards.handle();
    }


}
