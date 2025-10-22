package org.MustacheTeam.MagicTrade.corelogics.usecases.wishlist;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.WishlistRepository;

public class DeleteWishlistItem {
    private final WishlistRepository repository;

    public DeleteWishlistItem(WishlistRepository repository) {
        this.repository = repository;
    }

    public void handle(Long userId, String cardId) {
        repository.deleteByUserIdAndCardId(userId, cardId);
    }
}
