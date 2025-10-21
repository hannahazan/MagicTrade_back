package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.wishlist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataWishlistRepository extends JpaRepository<WishlistEntity, Long> {
    WishlistEntity findByUser_Id(Long id);
    List<WishlistEntity> findByUser_IdAndCard_Id(Long userId, String cardId);
}