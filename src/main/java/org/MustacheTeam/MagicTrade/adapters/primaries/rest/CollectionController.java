package org.MustacheTeam.MagicTrade.adapters.primaries.rest;

import jakarta.transaction.Transactional;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.card.SpringDataCardRepository;
import org.MustacheTeam.MagicTrade.adapters.security.CurrentTrader;
import org.MustacheTeam.MagicTrade.corelogics.models.collection.Collection;
import org.MustacheTeam.MagicTrade.corelogics.models.collection.CollectionCard;
import org.MustacheTeam.MagicTrade.corelogics.models.collection.CollectionUserList;
import org.MustacheTeam.MagicTrade.corelogics.usecases.collection.CreateCollection;
import org.MustacheTeam.MagicTrade.corelogics.usecases.collection.DeleteCollectionItem;
import org.MustacheTeam.MagicTrade.corelogics.usecases.collection.GetCollection;
import org.MustacheTeam.MagicTrade.corelogics.usecases.collection.GetUserAndCardFromCollection;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("magicTrade-api/collections")
public class CollectionController {

    private final CreateCollection createCollection;
    private final GetCollection getCollection;
    private final DeleteCollectionItem deleteCollectionItem;
    private final GetUserAndCardFromCollection getUserAndCardFromCollection;

    public CollectionController(
            CreateCollection createCollection,
            GetCollection getCollection,
            SpringDataCardRepository cardRepository,
            DeleteCollectionItem deleteCollectionItem,
            GetUserAndCardFromCollection getUserAndCardFromCollection
    ) {
        this.createCollection = createCollection;
        this.getCollection = getCollection;
        this.deleteCollectionItem = deleteCollectionItem;
        this.getUserAndCardFromCollection = getUserAndCardFromCollection;
    }

    @PostMapping
    public void addCardToCollection(
            @RequestBody Collection collectionDto,
            @AuthenticationPrincipal CurrentTrader currentTrader
    ) {
        createCollection.handle(collectionDto, currentTrader.getId());
    }

    @GetMapping("/MyCollection")
    public List<CollectionCard> getMyCollection(@AuthenticationPrincipal CurrentTrader trader) {
        return getCollection.handle(trader.getId());
    }

    @GetMapping("/{userId}")
    public List<CollectionCard> getCollectionByUserId(@PathVariable Long userId) {
        return getCollection.handle(userId);
    }

    @GetMapping("/{cardId}/users")
    public CollectionUserList getUsersFromCardId(@PathVariable String cardId){
        return getUserAndCardFromCollection.handle(cardId);
    }

    @DeleteMapping("/MyCollection/{collectionId}")
    @Transactional
    public void deleteCollectionItem(
            @PathVariable Long collectionId,
            @AuthenticationPrincipal CurrentTrader trader
    ) {
        deleteCollectionItem.handle(collectionId, trader.getId());
    }
}
