package org.MustacheTeam.MagicTrade.corelogics.usecases.user;

import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.User.UserEntity;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.User.JpaUserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GetUserById {

    private final JpaUserRepository repository;

    public GetUserById(JpaUserRepository repository){
        this.repository = repository;
    }

    public UserEntity handle(Long id){
        Optional<UserEntity> userOpt = repository.getUserById(id);
        return userOpt.orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
    }
}
