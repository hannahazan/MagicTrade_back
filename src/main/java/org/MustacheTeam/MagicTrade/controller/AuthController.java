package org.MustacheTeam.MagicTrade.controller;

import jakarta.validation.Valid;
import org.MustacheTeam.MagicTrade.dto.UserDto;
import org.MustacheTeam.MagicTrade.dto.UserLoginDto;
import org.MustacheTeam.MagicTrade.model.User;
import org.MustacheTeam.MagicTrade.security.AuthenticationService;
import org.MustacheTeam.MagicTrade.service.user.CreateUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CreateUser createUser;
    private final AuthenticationService authenticationService;

    public AuthController(CreateUser createUser, AuthenticationService authenticationService) {
        this.createUser = createUser;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDto userDto) {
        Set<String> roles = Set.of("USER");

        try {
            User createdUser = createUser.createUser(userDto, roles);
            return ResponseEntity.ok("User registered successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody UserLoginDto userLoginDto) {
        String token = authenticationService.authenticate(
                userLoginDto.getEmail(),
                userLoginDto.getPassword()
        );
        return ResponseEntity.ok(token);
    }
}

