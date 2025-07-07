package org.MustacheTeam.MagicTrade.controller;

import org.MustacheTeam.MagicTrade.dto.UserDto;
import org.MustacheTeam.MagicTrade.service.user.CreateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("magicTrade-api/users")
public class UserController {

    @Autowired
    CreateUser createUser;

    @PostMapping
    public void create(@RequestBody UserDto userDto){
        UserDto user = new UserDto(userDto.email(), userDto.pseudo(), userDto.name(), userDto.subName(), userDto.postalCode());
        createUser.handle(user);
    }

}
