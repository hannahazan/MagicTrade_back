package org.MustacheTeam.MagicTrade.service.user;

import org.MustacheTeam.MagicTrade.dto.UserDto;
import org.MustacheTeam.MagicTrade.model.User;
import org.MustacheTeam.MagicTrade.repository.User.JpaUserRepository;
import org.MustacheTeam.MagicTrade.repository.User.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CreateUser {

    private final UserRepository repository;

    public CreateUser( UserRepository userRepository) {
        this.repository = userRepository;
    }

    public void handle(UserDto userDto, Set<String> roles) {
        repository.save(userDto, roles);
    }
}
