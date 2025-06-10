package org.MustacheTeam.MagicTrade.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
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

}
