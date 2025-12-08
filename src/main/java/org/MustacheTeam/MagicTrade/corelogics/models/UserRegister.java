package org.MustacheTeam.MagicTrade.corelogics.models;

public record UserRegister(
        String email,
        String password,
        String pseudo,
        String country,
        String department,
        String city
) {

}
