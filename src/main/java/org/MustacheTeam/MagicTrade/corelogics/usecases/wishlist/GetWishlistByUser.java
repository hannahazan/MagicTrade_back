package org.MustacheTeam.MagicTrade.corelogics.usecases.wishlist;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.WishlistRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.wishlist.WishlistCard;

import java.util.List;

public class GetWishlistByUser {
    private final WishlistRepository repository;

    public GetWishlistByUser(WishlistRepository repository) {
        this.repository = repository;
    }

    public List<WishlistCard> handle(Long userId) {
        return repository.findByUserId(userId);
    }
}
