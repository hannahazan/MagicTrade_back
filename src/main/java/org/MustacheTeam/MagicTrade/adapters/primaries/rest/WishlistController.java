package org.MustacheTeam.MagicTrade.adapters.primaries.rest;

import org.MustacheTeam.MagicTrade.adapters.security.CurrentTrader;
import org.MustacheTeam.MagicTrade.corelogics.models.wishlist.WishlistCard;
import org.MustacheTeam.MagicTrade.corelogics.models.wishlist.WishlistRequest;
import org.MustacheTeam.MagicTrade.corelogics.usecases.wishlist.CreateWishlistItem;
import org.MustacheTeam.MagicTrade.corelogics.usecases.wishlist.DeleteWishlistItem;
import org.MustacheTeam.MagicTrade.corelogics.usecases.wishlist.GetWishlistByUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("magicTrade-api")
public class WishlistController {

    private final CreateWishlistItem createWishlistItem;
    private final GetWishlistByUser getWishlistByUser;
    private final DeleteWishlistItem deleteWishlistItem;

    public WishlistController(CreateWishlistItem createWishlistItem, GetWishlistByUser getWishlistByUser, DeleteWishlistItem deleteWishlistItem) {
        this.createWishlistItem = createWishlistItem;
        this.getWishlistByUser = getWishlistByUser;
        this.deleteWishlistItem = deleteWishlistItem;
    }

    @GetMapping("/wishlist")
    public List<WishlistCard> getWishlist(@AuthenticationPrincipal CurrentTrader user) {
        return getWishlistByUser.handle(user.getId());
    }

    @GetMapping("/users/{userId}/wishlist")
    public List<WishlistCard> getWishlistByUser(@PathVariable Long userId) {
        return getWishlistByUser.handle(userId);
    }

    @PostMapping("/wishlist")
    public void addCard(@RequestBody WishlistRequest request, @AuthenticationPrincipal CurrentTrader user) {
        createWishlistItem.handle(user.getId(), request.cardId());
    }

    @DeleteMapping("/wishlist/{cardId}")
    public void removeCard(@PathVariable String cardId, @AuthenticationPrincipal CurrentTrader user) {
        deleteWishlistItem.handle(user.getId(), cardId);
    }
}
