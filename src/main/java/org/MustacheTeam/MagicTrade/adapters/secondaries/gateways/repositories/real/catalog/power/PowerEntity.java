package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.power;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "powers")
@Getter
@Setter
@NoArgsConstructor
public class PowerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String value;

    public PowerEntity(String value) {
        this.value = value;
    }
}
