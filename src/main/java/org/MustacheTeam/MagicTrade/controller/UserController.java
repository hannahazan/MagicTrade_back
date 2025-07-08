package org.MustacheTeam.MagicTrade.controller;

import org.MustacheTeam.MagicTrade.dto.UserDto;
import org.MustacheTeam.MagicTrade.model.User;
import org.MustacheTeam.MagicTrade.service.user.CreateUser;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import org.MustacheTeam.MagicTrade.service.user.GetUserById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("magicTrade-api/users")
public class UserController {

    private final CreateUser createUser;

    public UserController(CreateUser createUser) {
        this.createUser = createUser;
    }

    @Autowired
    GetUserById getUserById;

    @PostMapping
    public UserDto create(@RequestBody UserDto userDto) {
        Set<String> defaultRoles = Set.of("USER");

        User createdUser = createUser.createUser(userDto, defaultRoles);

        return new UserDto(
                createdUser.getEmail(),
                createdUser.getPseudo(),
                createdUser.getName(),
                createdUser.getSubName(),
                createdUser.getPostalCode(),
                ""
        );
    public void create(@RequestBody UserDto userDto){;
        createUser.handle(userDto);
    }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable Long id){
        return getUserById.handle(id);
    }

}
