package org.MustacheTeam.MagicTrade.corelogics.models.exception;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String resourceName, String fieldName) {
        super(String.format("%s with this %s already exists", resourceName, fieldName));
    }
}
