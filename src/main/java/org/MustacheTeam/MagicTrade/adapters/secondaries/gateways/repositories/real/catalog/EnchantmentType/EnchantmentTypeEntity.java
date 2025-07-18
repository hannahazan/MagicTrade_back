package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.EnchantmentType;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "EnchantmentType")
@Getter
@Setter
@NoArgsConstructor
public class EnchantmentTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String value;

    public EnchantmentTypeEntity(String value) {
        this.value = value;
    }
}