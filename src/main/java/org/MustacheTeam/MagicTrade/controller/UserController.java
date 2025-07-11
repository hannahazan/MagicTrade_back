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
    public UserDto create(@Valid @RequestBody UserDto userDto) {
        Set<String> defaultRoles = Set.of("ROLE_USER");
        User createdUser = createUser.createUser(userDto, defaultRoles);
        return new UserDto(
                createdUser.getEmail(),
                createdUser.getPseudo(),
                createdUser.getName(),
                createdUser.getSubName(),
                createdUser.getCountry(),
                createdUser.getDepartment(),
                createdUser.getCity(),
                ""
        );
    }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable Long id) {
        return getUserById.handle(id);
    }
}
