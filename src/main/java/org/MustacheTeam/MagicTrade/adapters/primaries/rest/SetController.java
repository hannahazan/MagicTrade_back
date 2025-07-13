package org.MustacheTeam.MagicTrade.adapters.primaries.rest;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.model.ScryfallSet;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.api.RealScryfallGateway;
import org.MustacheTeam.MagicTrade.corelogics.usecases.set.RefreshSets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("magicTrade-api/sets")
public class SetController {

    @Autowired
    RealScryfallGateway realScryfallGateway;

    @Autowired
    RefreshSets refreshSets;

    @GetMapping
    public List<ScryfallSet> refreshSet(){
        return realScryfallGateway.getScryfallSets();
    }

    @PostMapping
    public void refreshSets(){
        refreshSets.handle();
    }

}
