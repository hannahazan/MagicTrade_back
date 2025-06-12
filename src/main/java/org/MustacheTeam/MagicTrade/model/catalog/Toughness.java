package org.MustacheTeam.MagicTrade.model.catalog;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "toughnesses")
@Getter
@Setter
@NoArgsConstructor
public class Toughness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String value;

    public Toughness(String value) {
        this.value = value;
    }
}
