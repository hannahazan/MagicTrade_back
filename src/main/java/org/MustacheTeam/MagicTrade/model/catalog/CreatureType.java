package org.MustacheTeam.MagicTrade.model.catalog;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "creatureTypes")
@Getter
@Setter
@NoArgsConstructor
public class CreatureType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String creatureType;

    public CreatureType( String creatureType){
        this.creatureType = creatureType;
    }

}
