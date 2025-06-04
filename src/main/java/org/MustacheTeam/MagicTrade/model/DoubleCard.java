package org.MustacheTeam.MagicTrade.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "doubleCards")
@Getter
@Setter
public class DoubleCard {
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

    public String getId(){
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardId(){
        return cardId;
    }

    public String getManaCost(){
        return manaCost;
    }

    public String getName(){
        return name;
    }

    public String getPower() {
        return power;
    }

    public String getImageSizeNormal() {
        return imageSizeNormal;
    }

    public String getImageSizeArtCrop() {
        return imageSizeArtCrop;
    }

    public String getToughness() {
        return toughness;
    }

    public String getText() {
        return text;
    }

    public String getTypeLine() {
        return typeLine;
    }

    public DoubleCard(){}

    public DoubleCard(String id,String cardId, String name, String manaCost, String typeLine, String text,String power, String toughness, String imageSizeNormal, String imageSizeArtCrop){
        this.id = id;
        this.cardId = cardId;
        this.name = name;
        this.manaCost = manaCost;
        this.typeLine = typeLine;
        this.text = text;
        this.power = power;
        this.toughness = toughness;
        this.imageSizeNormal =imageSizeNormal;
        this.imageSizeArtCrop = imageSizeArtCrop;
    }

}
