package org.MustacheTeam.MagicTrade.dto;

public record UserDto(
        String email,
        String pseudo,
        String name,
        String subName,
        int postalCode
) {
}
