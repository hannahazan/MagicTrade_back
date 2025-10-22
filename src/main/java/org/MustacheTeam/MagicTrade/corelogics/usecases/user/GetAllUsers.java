package org.MustacheTeam.MagicTrade.corelogics.usecases.user;

import org.MustacheTeam.MagicTrade.corelogics.gateways.repositories.UserRepository;
import org.MustacheTeam.MagicTrade.corelogics.models.UserList;

public class GetAllUsers {
    private final UserRepository repository;

    public GetAllUsers(UserRepository repository){
        this.repository = repository;
    }

    public UserList handle(){
         return repository.findAllUsers();
    }

}
