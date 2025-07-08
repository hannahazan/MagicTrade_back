package org.MustacheTeam.MagicTrade.controller;

import org.MustacheTeam.MagicTrade.model.Card;
import org.MustacheTeam.MagicTrade.service.card.GetAllCards;
import org.MustacheTeam.MagicTrade.service.card.GetCardById;
import org.MustacheTeam.MagicTrade.service.card.RefreshCards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("magicTrade-api/cards")
public class CardController {

    @Autowired
    private RefreshCards refreshCards;

    @Autowired
    private GetAllCards getAllCards;

    @Autowired
    private GetCardById getCardById;


    @PostMapping
    public void refreshcard(){
        refreshCards.handle();
    }

    @GetMapping
    public List<Card> getcards(){
        return getAllCards.handle();
    }

    @GetMapping("/{id}")
    public Card getOneCardById(@PathVariable String id){
            return getCardById.handle(id);
    }

}
