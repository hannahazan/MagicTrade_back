package org.MustacheTeam.MagicTrade.controller;

import org.MustacheTeam.MagicTrade.dto.CollectionDto;
import org.MustacheTeam.MagicTrade.service.collection.CreateCollection;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void setCreateCollection(@RequestBody List<CollectionDto> collectionDtoList){
        createCollection.handle(collectionDtoList);
    }
}
