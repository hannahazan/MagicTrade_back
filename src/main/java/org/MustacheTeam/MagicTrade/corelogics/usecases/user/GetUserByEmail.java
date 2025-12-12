package org.MustacheTeam.MagicTrade.corelogics.usecases.user;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.real.user.JpaUserRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.ConnectedUser;
import org.MustacheTeam.MagicTrade.corelogics.models.User;
import org.springframework.stereotype.Service;

@Service
public class GetUserByEmail {

    private final JpaUserRepository repository;

    public GetUserByEmail(JpaUserRepository repository) {
        this.repository = repository;
    }

    public ConnectedUser handle(String email) {
        return repository.findUserByEmail(email);

    }
}
