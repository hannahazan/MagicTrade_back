package org.MustacheTeam.MagicTrade.model.catalog;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "card_types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    public CardType(String name) {
        this.name = name;
    }
}
