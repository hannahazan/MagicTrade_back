package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.doublecard;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.card.CardEntity;

@Entity
@Table(name = "doubleCards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoubleCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "card_id", referencedColumnName = "id", nullable = false)
    private CardEntity card;

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


    public DoubleCardEntity(CardEntity entityCard, String name, String s, String s1, String s2, String power, String toughness, String s3, String s4) {
        this.card = entityCard;
        this.name = name;
        this.manaCost = s;
        this.typeLine = s1;
        this.text = s2;
        this.power = power;
        this.toughness = toughness;
        this.imageSizeNormal = s3;
        this.imageSizeArtCrop = s4;

    }
}
