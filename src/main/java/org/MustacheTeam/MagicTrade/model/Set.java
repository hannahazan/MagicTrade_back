package org.MustacheTeam.MagicTrade.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sets")
@Getter
@Setter
public class Set {
  @Id
  String id;

  @Column
  String name;

  @Column
  String setSymbol;

  public Set(){}

  public Set(String id,String name, String setSymbol){
      this.id= id;
      this.name = name;
      this.setSymbol = setSymbol;

  }

}
