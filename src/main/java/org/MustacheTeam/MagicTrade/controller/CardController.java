package org.MustacheTeam.MagicTrade.controller;

import org.MustacheTeam.MagicTrade.gateway.model.ScryfallCard;
import org.MustacheTeam.MagicTrade.gateway.model.ScryfallCardFinal;
import org.MustacheTeam.MagicTrade.gateway.service.RealScryfallGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("magicTrade-api/cards")
public class CardController {

    @Autowired
    private RealScryfallGateway realScryfallGateway;

    @GetMapping
    public List<ScryfallCardFinal> getAllCards(){
        return realScryfallGateway.getScryfallCards();
    }

}
