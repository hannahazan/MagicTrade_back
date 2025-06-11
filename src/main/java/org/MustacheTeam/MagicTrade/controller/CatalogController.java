package org.MustacheTeam.MagicTrade.controller;

import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.model.CardType;
import org.MustacheTeam.MagicTrade.service.cardType.GetAllCardTypes;
import org.MustacheTeam.MagicTrade.service.cardType.RefreshCardTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("magicTrade-api/catalog")
public class CatalogController {

    @Autowired
    RefreshCardTypes refreshCardTypes;

    @Autowired
    GetAllCardTypes getAllCardTypes;

    @GetMapping("card-types")
    public ResponseEntity<List<CardType>> getAllCardTypes() {
        List<CardType> cardTypes = getAllCardTypes.handle();
        if (cardTypes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cardTypes);
    }

    @PostMapping("/card-types")
    public void refreshCardTypes() {
        refreshCardTypes.handle();
    }
}
