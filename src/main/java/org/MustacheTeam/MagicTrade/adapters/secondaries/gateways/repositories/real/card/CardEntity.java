package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.card;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.doublecard.DoubleCardEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardEntity {

    @Id
    @Column(nullable = false, updatable = false)
    private String id;

    @Column
    private String setId;

    @Column
    private String name;

    @Column
    private String manaCost;

    @Column
    private int cmc;

    @Column
    private String types;

    @Column(columnDefinition = "TEXT")
    private String text;

    @Column
    private String toughness;

    @Column
    private String power;

    @Column
    private String rarity;

    @Column
    private Boolean foil;

    @Column
    private Boolean fullArt;

    @Column
    private Boolean textLess;

    @Column
    private String cardMarketPrice;

    @Column
    private String standard;

    @Column
    private String pioneer;

    @Column
    private String explorer;

    @Column
    private String modern;

    @Column
    private String legacy;

    @Column
    private String pauper;

    @Column
    private String vintage;

    @Column
    private String commander;

    @Column
    private String brawl;

    @Column
    private String pauperCommander;

    @Column
    private String duel;

    @Column
    private String oldSchool;

    @Column
    private String imageSizeNormal;

    @Column
    private String imageSizeArtCrop;

    @Column
    private Boolean isDoubleCard;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DoubleCardEntity> doubleCards = new ArrayList<>();


    public CardEntity(String id, String setId, String name, String manaCost, int cmc, String types, String text, String toughness, String power, String rarity,
                      Boolean foil, Boolean fullArt, Boolean textLess, String cardMarketPrice, String standard, String pioneer,
                      String explorer, String modern, String legacy, String pauper, String vintage, String commander, String brawl,
                      String pauperCommander, String duel, String oldschool, String imageSizeNormal, String imageSizeArtCrop, boolean isDoubleCard) {
    this.id = id;
    this.setId = setId;
    this.name = name;
    this.manaCost = manaCost;
    this.cmc = cmc;
    this.types = types;
    this.text = text;
    this.toughness = toughness;
    this.power = power;
    this.rarity = rarity;
    this.foil = foil;
    this.fullArt = fullArt;
    this.textLess = textLess;
    this.cardMarketPrice = cardMarketPrice;
    this.standard = standard;
    this.pioneer = pioneer;
    this.explorer = explorer;
    this.modern = modern;
    this.legacy = legacy;
    this.pauper = pauper;
    this.vintage = vintage;
    this.commander = commander;
    this.brawl = brawl;
    this.pauperCommander = pauperCommander;
    this.duel = duel;
    this.oldSchool = oldschool;
    this.imageSizeNormal = imageSizeNormal;
    this.imageSizeArtCrop = imageSizeArtCrop;
    this.isDoubleCard = isDoubleCard;
    }
}
