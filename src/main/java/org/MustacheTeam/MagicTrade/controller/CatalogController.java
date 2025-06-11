package org.MustacheTeam.MagicTrade.controller;

import org.MustacheTeam.MagicTrade.model.catalog.CardType;
import org.MustacheTeam.MagicTrade.model.catalog.Power;
import org.MustacheTeam.MagicTrade.model.catalog.Toughness;
import org.MustacheTeam.MagicTrade.service.catalog.cardType.GetAllCardTypes;
import org.MustacheTeam.MagicTrade.service.catalog.cardType.RefreshCardTypes;
import org.MustacheTeam.MagicTrade.service.catalog.creaturetype.RefreshCreatureTypes;
import org.MustacheTeam.MagicTrade.service.catalog.power.GetAllPowers;
import org.MustacheTeam.MagicTrade.service.catalog.power.RefreshPowers;
import org.MustacheTeam.MagicTrade.service.catalog.toughness.GetAllToughnesses;
import org.MustacheTeam.MagicTrade.service.catalog.toughness.RefreshToughnesses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("magicTrade-api/catalog")
public class CatalogController {

    @Autowired
    RefreshCreatureTypes refreshCreatureTypes;

    @Autowired
    RefreshCardTypes refreshCardTypes;

    @Autowired
    GetAllCardTypes getAllCardTypes;

    @Autowired
    RefreshPowers refreshPowers;

    @Autowired
    GetAllPowers getAllPowers;

    @Autowired
    RefreshToughnesses refreshToughnesses;

    @Autowired
    GetAllToughnesses getAllToughnesses;


    @PostMapping("creature-types")
    public void  refreshCatalogElements(@RequestParam String catalogElementName) {
        refreshCreatureTypes.handle(catalogElementName);
    }

    @GetMapping("card-types")
    public ResponseEntity<List<CardType>> getAllCardTypes() {
        List<CardType> cardTypes = getAllCardTypes.handle();
        if (cardTypes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cardTypes);
    }

    @PostMapping("/card-types")
    public void refreshCardTypes(@RequestParam String catalogElementName) {
        refreshCardTypes.handle(catalogElementName);
    }

    @GetMapping("powers")
    public ResponseEntity<List<Power>> getAllPowers() {
        List<Power> powers = getAllPowers.handle();
        if (powers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(powers);
    }

    @PostMapping("powers")
    public void refreshPowers(@RequestParam String catalogElementName) {
        refreshPowers.handle(catalogElementName);
    }

    @GetMapping("toughnesses")
    public ResponseEntity<List<Toughness>> getAllToughnesses() {
        List<Toughness> toughnesses = getAllToughnesses.handle();
        if (toughnesses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(toughnesses);
    }

    @PostMapping("toughnesses")
    public void refreshToughnesses(@RequestParam String catalogElementName) {
        refreshToughnesses.handle(catalogElementName);
    }
}
