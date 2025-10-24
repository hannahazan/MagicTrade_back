package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.collection;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.UserEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.card.CardEntity;
import org.MustacheTeam.MagicTrade.corelogics.models.enumeration.CardState;

@Entity
@Table(name = "collections")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CollectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userId;

    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private CardEntity cardId;

    @Column(nullable = false, length = 5)
    private String lang;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10, columnDefinition = "VARCHAR(10)")
    private CardState state;

    public CollectionEntity(UserEntity user, CardEntity card, String lang, CardState state) {
        this.userId = user;
        this.cardId = card;
        this.lang = lang;
        this.state = state;
    }
}
