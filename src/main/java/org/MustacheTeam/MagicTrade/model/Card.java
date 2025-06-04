package org.MustacheTeam.MagicTrade.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cards")
@Getter
@Setter
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

    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSetId() {
        return setId;
    }

    public void setSetId(String setId){
        this.setId = setId;
    }

    public String getManaCost(){
        return manaCost;
    }

    public void setManaCost(String manaCost){
        this.manaCost = manaCost;
    }

    public int getCmc() {
        return cmc;
    }

    public void setCmc(int cmc){
        this.cmc = cmc;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types){
        this.types = types;
    }

    public String getText() {
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness){
        this.toughness = toughness;
    }

    public String getBrawl() {
        return brawl;
    }

    public void setBrawl(String brawl) {
        this.brawl = brawl;
    }

    public String getCardMarketPrice() {
        return cardMarketPrice;
    }

    public void setCardMarketPrice(String cardMarketPrice) {
        this.cardMarketPrice = cardMarketPrice;
    }

    public Boolean getFoil() {
        return foil;
    }

    public void setFoil(Boolean foil) {
        this.foil = foil;
    }

    public Boolean getFullArt() {
        return fullArt;
    }

    public void setFullArt(Boolean fullArt) {
        this.fullArt = fullArt;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public Boolean getTextLess() {
        return textLess;
    }

    public void setTextLess(Boolean textLess) {
        this.textLess = textLess;
    }

    public String getCommander() {
        return commander;
    }

    public void setCommander(String commander) {
        this.commander = commander;
    }

    public String getDuel() {
        return duel;
    }

    public void setDuel(String duel) {
        this.duel = duel;
    }

    public String getExplorer() {
        return explorer;
    }

    public void setExplorer(String explorer) {
        this.explorer = explorer;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getImageSizeArtCrop() {
        return imageSizeArtCrop;
    }

    public void setImageSizeArtCrop(String imageSizeArtCrop) {
        this.imageSizeArtCrop = imageSizeArtCrop;
    }

    public String getImageSizeNormal() {
        return imageSizeNormal;
    }

    public void setImageSizeNormal(String imageSizeNormal) {
        this.imageSizeNormal = imageSizeNormal;
    }

    public String getLegacy() {
        return legacy;
    }

    public void setLegacy(String legacy) {
        this.legacy = legacy;
    }

    public String getModern() {
        return modern;
    }

    public void setModern(String modern) {
        this.modern = modern;
    }

    public String getOldSchool() {
        return oldSchool;
    }

    public void setOldSchool(String oldSchool) {
        this.oldSchool = oldSchool;
    }

    public String getPauper() {
        return pauper;
    }

    public void setPauper(String pauper) {
        this.pauper = pauper;
    }

    public String getPauperCommander() {
        return pauperCommander;
    }

    public void setPauperCommander(String pauperCommander) {
        this.pauperCommander = pauperCommander;
    }

    public String getPioneer() {
        return pioneer;
    }

    public void setPioneer(String pioneer) {
        this.pioneer = pioneer;
    }

    public String getVintage() {
        return vintage;
    }

    public void setVintage(String vintage) {
        this.vintage = vintage;
    }

    public Card(){

    }

    public Card(String id, String setId, String name, String manaCost, int cmc, String types, String text, String toughness, String power, String rarity, Boolean foil, Boolean fullArt, Boolean textLess, String cardMarketPrice, String standard, String pioneer, String explorer, String modern, String legacy, String pauper, String vintage, String commander, String brawl, String pauperCommander, String duel, String oldschool, String imageSizeNormal, String imageSizeArtCrop) {
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
    }
}
