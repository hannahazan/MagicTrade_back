package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.collection;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.card.CardEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.User.UserEntity;

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
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private CardEntity cardId;

    @Column
    private String lang;

    @Column
    private String state;


    public CollectionEntity(UserEntity user, CardEntity card, String lang, String state){
        this.userId = user;
        this.cardId = card;
        this.lang = lang;
        this.state = state;
    }
}
