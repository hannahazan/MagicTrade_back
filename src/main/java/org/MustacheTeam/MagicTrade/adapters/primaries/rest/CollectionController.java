package org.MustacheTeam.MagicTrade.adapters.primaries.rest;

import org.MustacheTeam.MagicTrade.adapters.security.CurrentTrader;
import org.MustacheTeam.MagicTrade.corelogics.models.Collection;
import org.MustacheTeam.MagicTrade.corelogics.usecases.collection.CreateCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("magicTrade-api/collections")
public class CollectionController {
    @Autowired
    private CreateCollection createCollection;

    @PostMapping
    public void setCreateCollection(@RequestBody List<Collection> collectionDtoList, @AuthenticationPrincipal CurrentTrader currentTraderId){
        createCollection.handle(collectionDtoList, currentTraderId.getId());
    }
}
