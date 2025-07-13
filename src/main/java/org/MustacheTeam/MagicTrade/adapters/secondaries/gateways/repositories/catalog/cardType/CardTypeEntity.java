package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.catalog.cardType;

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
public class CardTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    public CardTypeEntity(String name) {
        this.name = name;
    }
}
