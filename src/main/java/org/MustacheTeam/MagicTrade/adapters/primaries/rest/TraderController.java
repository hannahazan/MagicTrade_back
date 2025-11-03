package org.MustacheTeam.MagicTrade.adapters.primaries.rest;

import org.MustacheTeam.MagicTrade.corelogics.models.trader.TraderPreview;
import org.MustacheTeam.MagicTrade.corelogics.usecases.traders.GetAllTraders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/magicTrade-api/traders")
public class TraderController {

    private final GetAllTraders getAllTraders;

    public TraderController(GetAllTraders getAllTraders) {
        this.getAllTraders = getAllTraders;
    }

    @GetMapping
    public List<TraderPreview> getAllTraders() {
        return getAllTraders.handle();
    }
}
