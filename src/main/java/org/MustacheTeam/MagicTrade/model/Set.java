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
@Table(name = "sets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Set {
  @Id
  private String id;

  @Column
  private String name;

  @Column
  private String setSymbol;

}
