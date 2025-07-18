package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.catalog.creaturetype;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "creatureTypes")
@Getter
@Setter
@NoArgsConstructor
public class CreatureTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String type;

    public CreatureTypeEntity(String creatureType){
        this.type = creatureType;
    }

}
