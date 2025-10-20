package org.MustacheTeam.MagicTrade.corelogics.usecases.user;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.User.JpaUserRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.UserDto;
import org.MustacheTeam.MagicTrade.corelogics.models.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GetUserByEmail {

    private final JpaUserRepository repository;

    public GetUserByEmail(JpaUserRepository repository) {
        this.repository = repository;
    }

    public UserDto handle(String email) {
        return repository.findUserDtoByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User with email '" + email + "' not found"));
    }
}
