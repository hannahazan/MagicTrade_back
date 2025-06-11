package org.MustacheTeam.MagicTrade.controller;

import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("magicTrade-api/catalog")
public class CatalogController {

    @Autowired
    RealScryfallGateway realScryfallGateway;

    @GetMapping
    public List<String> getCatalogElements(@RequestParam String catalogElementName) {
        return realScryfallGateway.getScryfallCatalog(catalogElementName);
    }
}
