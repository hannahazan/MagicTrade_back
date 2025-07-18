package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.cardname;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "card_names")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardNameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    public CardNameEntity(String name) {
        this.name = name;
    }
}
