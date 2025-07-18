package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.toughness;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "toughnesses")
@Getter
@Setter
@NoArgsConstructor
public class ToughnessEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String value;

    public ToughnessEntity(String value) {
        this.value = value;
    }
}
