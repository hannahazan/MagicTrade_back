package org.MustacheTeam.MagicTrade.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

@Entity
@Table(name = "collections")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card cardId;

    @Column
    private String lang;

    @Column
    private String state;


    public Collection(User user, Card card, String lang, String state){
        this.userId = user;
        this.cardId = card;
        this.state = state;
    }
}
