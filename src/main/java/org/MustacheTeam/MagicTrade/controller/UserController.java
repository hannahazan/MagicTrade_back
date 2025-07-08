package org.MustacheTeam.MagicTrade.controller;

import org.MustacheTeam.MagicTrade.dto.UserDto;
import org.MustacheTeam.MagicTrade.model.User;
import org.MustacheTeam.MagicTrade.service.user.CreateUser;
import org.MustacheTeam.MagicTrade.service.user.GetUserById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("magicTrade-api/users")
public class UserController {

    @Autowired
    CreateUser createUser;

    @Autowired
    GetUserById getUserById;

    @PostMapping
    public void create(@RequestBody UserDto userDto){;
        createUser.handle(userDto);
    }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable Long id){
        return getUserById.handle(id);
    }

}
