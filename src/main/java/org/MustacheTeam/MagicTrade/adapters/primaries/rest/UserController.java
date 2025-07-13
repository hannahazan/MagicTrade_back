package org.MustacheTeam.MagicTrade.adapters.primaries.rest;

import jakarta.validation.Valid;
import org.MustacheTeam.MagicTrade.corelogics.models.UserDto;
import org.MustacheTeam.MagicTrade.adapters.secondaries.gateways.repositories.User.UserEntity;
import org.MustacheTeam.MagicTrade.corelogics.usecases.user.CreateUser;
import org.MustacheTeam.MagicTrade.corelogics.usecases.user.GetUserById;
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
    public UserEntity getOneUser(@PathVariable Long id) {
        return getUserById.handle(id);
    }
}
