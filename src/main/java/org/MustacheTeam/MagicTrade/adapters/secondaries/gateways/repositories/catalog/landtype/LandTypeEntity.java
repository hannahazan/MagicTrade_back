package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.catalog.landtype;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "landTypes")
@Getter
@Setter
@NoArgsConstructor
public class LandTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String type;

    public LandTypeEntity(String landType){
        this.type = landType;
    }

}
