package org.MustacheTeam.MagicTrade.adapters.primaries.rest;

import org.MustacheTeam.MagicTrade.adapters.security.CurrentTrader;
import org.MustacheTeam.MagicTrade.corelogics.models.WishlistRequest;
import org.MustacheTeam.MagicTrade.corelogics.usecases.wishlist.CreateWishlistItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("magicTrade-api/wishlist")
public class WishlistController {

    private final CreateWishlistItem createWishlistItem;

    public WishlistController(CreateWishlistItem createWishlistItem) {
        this.createWishlistItem = createWishlistItem;
    }

    @GetMapping()
    public void getWishlist() {
        // TODO
    }

    @PostMapping
    public void addCard(@RequestBody WishlistRequest request, @AuthenticationPrincipal CurrentTrader user) {
        createWishlistItem.handle(user.getId(), request.cardId());
    }

    @DeleteMapping("/{cardId}")
    public void removeCard(@PathVariable String cardId, @AuthenticationPrincipal CurrentTrader user) {
        // TODO
    }
}
