package org.MustacheTeam.MagicTrade.service.user;

import org.MustacheTeam.MagicTrade.model.User;
import org.MustacheTeam.MagicTrade.repository.User.JpaUserRepository;

public class GetUserById {
    private final JpaUserRepository repository;

    public GetUserById(JpaUserRepository jpaUserRepository){
        this.repository = jpaUserRepository;
    }

    public User handle(Long id){
        return repository.getUserById(id);
    }
}
