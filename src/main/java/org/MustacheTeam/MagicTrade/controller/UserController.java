package org.MustacheTeam.MagicTrade.controller;

import jakarta.validation.Valid;
import org.MustacheTeam.MagicTrade.dto.UserDto;
import org.MustacheTeam.MagicTrade.model.User;
import org.MustacheTeam.MagicTrade.service.user.CreateUser;
import org.MustacheTeam.MagicTrade.service.user.GetUserById;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("magicTrade-api/users")
public class UserController {

    private final CreateUser createUser;
    private final GetUserById getUserById;

    public UserController(CreateUser createUser, GetUserById getUserById) {
        this.createUser = createUser;
        this.getUserById = getUserById;
    }

    @PostMapping
    public void create(@Valid @RequestBody UserDto userDto) {
        Set<String> defaultRoles = Set.of("ROLE_USER");
        createUser.handle(userDto, defaultRoles);
    }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable Long id) {
        return getUserById.handle(id);
    }
}
