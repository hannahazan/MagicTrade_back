package org.MustacheTeam.MagicTrade.adapters.security;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.user.SpringDataUserRepository;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.user.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final SpringDataUserRepository userRepository;

    public CustomUserDetailsService(SpringDataUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity u = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));

        List<GrantedAuthority> authorities =  List.of(new SimpleGrantedAuthority(u.getRole()));

        return new CurrentTrader(
                u.getId(),
                u.getEmail(),
                u.getPassword(),
                authorities,
                u.isEnabled()
        );

    }
}
