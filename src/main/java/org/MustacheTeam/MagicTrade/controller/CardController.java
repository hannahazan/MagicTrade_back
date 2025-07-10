package org.MustacheTeam.MagicTrade.controller;

import org.MustacheTeam.MagicTrade.model.Card;
import org.MustacheTeam.MagicTrade.service.card.GetAllCards;
import org.MustacheTeam.MagicTrade.service.card.GetCardById;
import org.MustacheTeam.MagicTrade.service.card.RefreshCards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    public void refreshCard(){
        refreshCards.handle();
    }

    @GetMapping
    public List<Card> getCards(){
        return getAllCards.handle();
    }

    @GetMapping("/filters")
    public List<Card> getCardsByFilter(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "set-id", required = false, defaultValue = "") String setId,
            @RequestParam(name = "colors", required = false, defaultValue = "") List<String> colors,
            @RequestParam(name = "cmc", required = false, defaultValue = "") List<Integer> cmc,
            @RequestParam(name ="text", required = false, defaultValue = "") String text
    ){
        return getAllCards.handleAll(name, setId, colors, cmc, text);
    }

    @GetMapping("/{id}")
    public Card getOneCardById(@PathVariable String id){
            return getCardById.handle(id);
    }

}
