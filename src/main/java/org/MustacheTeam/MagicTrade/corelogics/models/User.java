package org.MustacheTeam.MagicTrade.corelogics.models;

public record User(
    Long id,
    String pseudo,
    String country,
    String department,
    String city
) {
}
