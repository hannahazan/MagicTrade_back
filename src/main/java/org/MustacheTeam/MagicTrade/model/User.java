package org.MustacheTeam.MagicTrade.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false, length = 20)
    private String pseudo;

    @Column(nullable = false, length = 15)
    private String name;

    @Column(nullable = false, length = 15)
    private String subName;

    @Column(nullable = false)
    private int postalCode;

    public User(String email, String pseudo, String name, String subName, int postalCode){
        this.email = email;
        this.pseudo = pseudo;
        this.name = name;
        this.subName = subName;
        this.postalCode = postalCode;
    }

}
