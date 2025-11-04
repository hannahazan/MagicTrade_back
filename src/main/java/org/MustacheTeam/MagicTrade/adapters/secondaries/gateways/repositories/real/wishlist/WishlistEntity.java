package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.wishlist;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.user.UserEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.card.CardEntity;

@Entity
@Table(
    name = "wishlists",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "card_id"})
    }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishlistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "card_id", nullable = false)
    private CardEntity card;
}
