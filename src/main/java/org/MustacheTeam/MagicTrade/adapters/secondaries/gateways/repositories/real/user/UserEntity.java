package org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.user;

import jakarta.persistence.*;
import lombok.*;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.rate.RateEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.trade.TradeEntity;
import org.MustacheTeam.MagicTrade.corelogics.models.trade.Trade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false, length = 20)
    private String pseudo;

    @Column(nullable = false, length = 30)
    private String country;

    @Column(nullable = false, length = 30)
    private String department;

    @Column(nullable = false, length = 30)
    private String city;

    @Column(nullable = false, length = 20)
    private String role;

    @OneToMany(mappedBy = "userRated", fetch = FetchType.LAZY)
    private List<RateEntity> rates = new ArrayList<>();

    public UserEntity(String email, String pseudo, String country, String department, String city, String password) {
        this.email = email;
        this.pseudo = pseudo;
        this.country = country;
        this.department = department;
        this.city = city;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
