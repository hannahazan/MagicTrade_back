package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.ability;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "abilities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AbilityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    public AbilityEntity(String name) {
        this.name = name;
    }
}
