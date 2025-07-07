package org.MustacheTeam.MagicTrade.service.user;

import org.MustacheTeam.MagicTrade.dto.UserDto;
import org.MustacheTeam.MagicTrade.repository.User.JpaUserRepository;

public class CreateUser {
    private  final JpaUserRepository repository;

    public CreateUser(JpaUserRepository jpaUserRepository){
        this.repository = jpaUserRepository;
    }

    public void handle(UserDto user){
        repository.save(user);
    }
}
