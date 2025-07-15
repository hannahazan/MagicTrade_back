package org.MustacheTeam.MagicTrade.adapters.primaries.rest;

import org.MustacheTeam.MagicTrade.corelogics.models.CardList;
import org.MustacheTeam.MagicTrade.corelogics.usecases.card.GetAllCards;
import org.MustacheTeam.MagicTrade.corelogics.usecases.card.RefreshCards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/magicTrade-api/cards")
public class CardController {

    @Autowired
    private RefreshCards refreshCards;

    @Autowired
    private GetAllCards getAllCards;

    @PostMapping
    public void refreshCard(){
        refreshCards.handle();
    }

    @GetMapping
    public CardList getCardsByFilter(
            @RequestParam(name = "id", required = false, defaultValue = "") String id,
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "set-id", required = false, defaultValue = "") String setId,
            @RequestParam(name = "colors", required = false, defaultValue = "") List<String> colors,
            @RequestParam(name = "cmc", required = false, defaultValue = "") List<Integer> cmc,
            @RequestParam(name ="text", required = false, defaultValue = "") String text,
            @RequestParam(name = "toughnesses", required = false, defaultValue = "") List<String> toughnesses,
            @RequestParam(name = "powers", required = false, defaultValue = "") List<String> powers,
            @RequestParam(name = "rarities", required = false, defaultValue = "") List<String> rarities,
            @RequestParam(name = "types",required = false, defaultValue = "") List<String> types,
            @RequestParam(name = "foil", required = false, defaultValue = "") String foil,
            @RequestParam(name = "fullArt", required = false, defaultValue = "") String fullArt,
            @RequestParam(name = "textLess", required = false, defaultValue = "") String textLess,
            @RequestParam(name = "standard", required = false, defaultValue = "") String standard,
            @RequestParam(name = "pioneer", required = false, defaultValue = "") String pioneer,
            @RequestParam(name = "explorer", required = false, defaultValue = "") String explorer,
            @RequestParam(name = "modern", required = false, defaultValue = "") String modern,
            @RequestParam(name = "legacy", required = false, defaultValue = "") String legacy,
            @RequestParam(name = "pauper", required = false, defaultValue = "") String pauper,
            @RequestParam(name = "vintage", required = false, defaultValue = "") String vintage,
            @RequestParam(name = "commander", required = false, defaultValue = "") String commander,
            @RequestParam(name = "brawl", required = false, defaultValue = "") String brawl,
            @RequestParam(name = "pauperCommander", required = false, defaultValue = "") String pauperCommander,
            @RequestParam(name = "duel", required = false, defaultValue = "") String duel,
            @RequestParam(name = "oldSchool", required = false, defaultValue = "") String oldSchool
    ){
        return getAllCards.handle(id,name, setId, colors, cmc, text, toughnesses, powers, rarities, types, foil, fullArt, textLess, standard,
                pioneer, explorer, modern, legacy, pauper, vintage, commander, brawl, pauperCommander, duel, oldSchool);
    }

}
