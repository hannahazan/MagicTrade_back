package org.MustacheTeam.MagicTrade.controller;

import org.MustacheTeam.MagicTrade.model.DoubleCard;
import org.MustacheTeam.MagicTrade.service.GetAllDoubleCards;
import org.MustacheTeam.MagicTrade.service.RefreshDoubleCards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("magicTrade-api/double-cards")
public class DoubleCardController {

    @Autowired
    RefreshDoubleCards refreshDoubleCards;

    @Autowired
    GetAllDoubleCards getAllDoubleCards;

    @PostMapping
    public void refresh(){
        refreshDoubleCards.handle();
    }

    @GetMapping
    public List<DoubleCard> getAllCards(){
        return getAllDoubleCards.handle();
    }


}

