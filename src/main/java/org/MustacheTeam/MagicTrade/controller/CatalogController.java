package org.MustacheTeam.MagicTrade.controller;

import org.MustacheTeam.MagicTrade.service.catalog.creaturetype.RefreshCreatureTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("magicTrade-api/catalog")
public class CatalogController {

    @Autowired
    RefreshCreatureTypes refreshCreatureTypes;

    @PostMapping("creature_type")
    public void  refreshCatalogElements(@RequestParam String catalogElementName) {
        refreshCreatureTypes.handle(catalogElementName);
    }
}
