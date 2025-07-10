package org.MustacheTeam.MagicTrade.service.user;

import org.MustacheTeam.MagicTrade.model.User;
import org.MustacheTeam.MagicTrade.repository.User.JpaUserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GetUserById {

    private final JpaUserRepository repository;

    public GetUserById(JpaUserRepository repository){
        this.repository = repository;
    }

    public User handle(Long id){
        Optional<User> userOpt = repository.getUserById(id);
        return userOpt.orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
    }
}
