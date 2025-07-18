package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.doublecard;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doubleCards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoubleCardEntity {
    @Id
    String id;

    @Column
    private String cardId;

    @Column
    private String name;

    @Column
    private String manaCost;

    @Column
    private String typeLine;

    @Column(columnDefinition = "TEXT")
    private String text;

    @Column
    private String power;

    @Column
    private String toughness;

    @Column
    private String imageSizeNormal;

    @Column
    private String imageSizeArtCrop;

}
