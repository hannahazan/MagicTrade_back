package org.MustacheTeam.MagicTrade.adapters.primaries.rest;

import jakarta.validation.Valid;
import org.MustacheTeam.MagicTrade.corelogics.models.UserDto;
import org.MustacheTeam.MagicTrade.corelogics.usecases.user.CreateUser;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("magicTrade-api/users")
public class UserController {

    private final CreateUser createUser;

    public UserController(CreateUser createUser) {
        this.createUser = createUser;
    }

    @PostMapping
    public void create(@Valid @RequestBody UserDto userDto) {
        Set<String> defaultRoles = Set.of("ROLE_USER");
        createUser.handle(userDto, defaultRoles);
    }

}
