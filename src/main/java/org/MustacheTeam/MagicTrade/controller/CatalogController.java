package org.MustacheTeam.MagicTrade.controller;

import org.MustacheTeam.MagicTrade.model.catalog.CardType;
import org.MustacheTeam.MagicTrade.service.catalog.cardType.GetAllCardTypes;
import org.MustacheTeam.MagicTrade.service.catalog.cardType.RefreshCardTypes;
import org.MustacheTeam.MagicTrade.service.catalog.cardname.GetAllCardNames;
import org.MustacheTeam.MagicTrade.service.catalog.cardname.RefreshCardNames;
import org.MustacheTeam.MagicTrade.service.catalog.creaturetype.GetAllCreatureTypes;
import org.MustacheTeam.MagicTrade.service.catalog.creaturetype.RefreshCreatureTypes;
import org.MustacheTeam.MagicTrade.service.catalog.landtype.GetAllLandTypes;
import org.MustacheTeam.MagicTrade.service.catalog.landtype.RefreshLandTypes;
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
    GetAllCreatureTypes getAllCreatureTypes;

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


    @Autowired
    RefreshLandTypes refreshLandTypes;

    @Autowired
    GetAllLandTypes getAllLandTypes;

    @Autowired
    RefreshCardNames refreshCardNames;

    @Autowired
    GetAllCardNames getAllCardNames;

    @PostMapping("creature-types")
    public void  refreshCatalogElements(@RequestParam String catalogElementName) {
        refreshCreatureTypes.handle(catalogElementName);
    }

    @GetMapping("creature-types")
    public List<String> getAllCreatureTypes(){
        return getAllCreatureTypes.handle();
    }


    @GetMapping("card-types")
    public ResponseEntity<List<CardType>> getAllCardTypes() {
        List<CardType> cardTypes = getAllCardTypes.handle();
        if (cardTypes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cardTypes);
    }

    @PostMapping("card-types")
    public void refreshCardTypes(@RequestParam String catalogElementName) {
        refreshCardTypes.handle(catalogElementName);
    }

    @GetMapping("powers")
    public ResponseEntity<List<String>> getAllPowers() {
        List<String> powers = getAllPowers.handle();
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
    public ResponseEntity<List<String>> getAllToughnesses() {
        List<String> toughnesses = getAllToughnesses.handle();
        if (toughnesses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(toughnesses);
    }

    @PostMapping("toughnesses")
    public void refreshToughnesses(@RequestParam String catalogElementName) {
        refreshToughnesses.handle(catalogElementName);
    }

    @PostMapping("land-types")
    public void refreshLandTypes(@RequestParam String catalogElementName){
        refreshLandTypes.handle(catalogElementName);
    }

    @GetMapping("land-types")
    public List<String> getAllLandTypes(){
        return getAllLandTypes.handle();
    }

    @PostMapping("card-names")
    public void setRefreshCardNames(@RequestParam String catalogElementName ){
        refreshCardNames.handle(catalogElementName);
    }

    @GetMapping("card-names")
    public List<String> getAllCardNames(){
        return getAllCardNames.handle();
    }

}
