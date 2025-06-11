package org.MustacheTeam.MagicTrade.model.catalog;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "powers")
@Getter
@Setter
@NoArgsConstructor
public class Power {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String value;

    public Power(String value) {
        this.value = value;
    }
}
