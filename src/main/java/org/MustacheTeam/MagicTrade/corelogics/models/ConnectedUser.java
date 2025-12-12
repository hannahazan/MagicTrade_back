package org.MustacheTeam.MagicTrade.corelogics.models;

public record ConnectedUser(
        Long id,
        String pseudo,
        String email,
        String country,
        String department,
        String city,
        String role
) {
}
