package org.MustacheTeam.MagicTrade.corelogics.usecases.user;

import org.MustacheTeam.MagicTrade.corelogics.models.UserDto;
import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.UserRepository;
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
