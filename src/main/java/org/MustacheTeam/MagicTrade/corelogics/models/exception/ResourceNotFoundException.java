package org.MustacheTeam.MagicTrade.corelogics.models.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
