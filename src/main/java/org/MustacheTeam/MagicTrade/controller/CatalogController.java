package org.MustacheTeam.MagicTrade.controller;

import org.MustacheTeam.MagicTrade.model.catalog.CardType;
import org.MustacheTeam.MagicTrade.service.catalog.cardType.GetAllCardTypes;
import org.MustacheTeam.MagicTrade.service.catalog.cardType.RefreshCardTypes;
import org.MustacheTeam.MagicTrade.service.catalog.creaturetype.RefreshCreatureTypes;
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
}
