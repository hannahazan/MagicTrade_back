package org.MustacheTeam.MagicTrade.model.catalog;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "landTypes")
@Getter
@Setter
@NoArgsConstructor
public class LandType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String type;

    public LandType( String landType){
        this.type = landType;
    }

}
