package org.MustacheTeam.MagicTrade.controller;

import org.MustacheTeam.MagicTrade.dto.Filters;
import org.MustacheTeam.MagicTrade.service.catalog.ability.GetAllAbilities;
import org.MustacheTeam.MagicTrade.service.catalog.ability.RefreshAbilities;
import org.MustacheTeam.MagicTrade.service.catalog.artifacttype.GetAllArtifactType;
import org.MustacheTeam.MagicTrade.service.catalog.artifacttype.RefreshArtifactType;
import org.MustacheTeam.MagicTrade.service.catalog.cardType.GetAllCardTypes;
import org.MustacheTeam.MagicTrade.service.catalog.cardType.RefreshCardTypes;
import org.MustacheTeam.MagicTrade.service.catalog.cardname.GetAllCardNames;
import org.MustacheTeam.MagicTrade.service.catalog.cardname.RefreshCardNames;
import org.MustacheTeam.MagicTrade.service.catalog.creaturetype.GetAllCreatureTypes;
import org.MustacheTeam.MagicTrade.service.catalog.creaturetype.RefreshCreatureTypes;
import org.MustacheTeam.MagicTrade.service.catalog.enchantmentType.GetAllEnchantmentTypes;
import org.MustacheTeam.MagicTrade.service.catalog.enchantmentType.RefreshEnchantmentType;
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

    @Autowired
    RefreshAbilities refreshAbilities;

    @Autowired
    GetAllAbilities getAllAbilities;

    @Autowired
    RefreshEnchantmentType refreshEnchantmentType;

    @Autowired
    GetAllEnchantmentTypes getAllEnchantmentTypes;

    @Autowired
    GetAllArtifactType getAllArtifactType;

    @Autowired
    RefreshArtifactType refreshArtifactType;


    @PostMapping("creature-types")
    public void  refreshCatalogElements(@RequestParam String catalogElementName) {
        refreshCreatureTypes.handle(catalogElementName);
    }

    @GetMapping("creature-types")
    public Filters getAllCreatureTypes(){
        return getAllCreatureTypes.handle();
    }


    @GetMapping("card-types")
    public ResponseEntity<?> getAllCardTypes() {
        Filters cardTypes = getAllCardTypes.handle();
        if (cardTypes.filters().isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cardTypes);
    }

    @PostMapping("card-types")
    public void refreshCardTypes(@RequestParam String catalogElementName) {
        refreshCardTypes.handle(catalogElementName);
    }

    @GetMapping("powers")
    public ResponseEntity<?> getAllPowers() {
        Filters powers = getAllPowers.handle();
        if (powers.filters().isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(powers);
    }

    @PostMapping("powers")
    public void refreshPowers(@RequestParam String catalogElementName) {
        refreshPowers.handle(catalogElementName);
    }

    @GetMapping("toughnesses")
    public ResponseEntity<?> getAllToughnesses() {
        Filters toughnesses = getAllToughnesses.handle();
        if (toughnesses.filters().isEmpty()) {
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
    public Filters getAllLandTypes(){
        return getAllLandTypes.handle();
    }

    @PostMapping("card-names")
    public void setRefreshCardNames(@RequestParam String catalogElementName ){
        refreshCardNames.handle(catalogElementName);
    }

    @GetMapping("card-names")
    public Filters getAllCardNames(){
        return getAllCardNames.handle();
    }

    @PostMapping("abilities")
    public void refreshAbilities(@RequestParam String catalogElementName){
        refreshAbilities.handle(catalogElementName);
    }

    @GetMapping("abilities")
    public Filters getAllAbilities(){
        return getAllAbilities.handle();
    }

    @PostMapping("enchantment-types")
    public void refreshEnchantmentTypes(@RequestParam String catalogElementName){
        refreshEnchantmentType.handle(catalogElementName);
    }

    @GetMapping("enchantment-types")
    public Filters getAllEnchantmentTypes(){
        return getAllEnchantmentTypes.handle();
    }

    @PostMapping("artifact-types")
    public void refreshArtifactTypes(@RequestParam String catalogElementName){
        refreshArtifactType.handle(catalogElementName);
    }

    @GetMapping("artifact-types")
    public Filters getAllArtifactTypes(){
        return getAllArtifactType.handle();
    }
}
