package org.MustacheTeam.MagicTrade.adapters.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CurrentTrader implements UserDetails {

    @Getter
    private final Long id;
    private final String username;
    private final String password;
    private final Collection authorities;
    private final boolean enabled;

    public CurrentTrader(Long id, String username, String password,
                           Collection authorities,
                           boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.enabled = enabled;
    }


    @Override public java.util.Collection<? extends GrantedAuthority> getAuthorities() { return authorities; }
    @Override public String getPassword() { return password; }
    @Override public String getUsername() { return username; }
    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return enabled; }
}
