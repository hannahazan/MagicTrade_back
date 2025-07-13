package org.MustacheTeam.MagicTrade.corelogics.models.exception;

public class ScryfallPersistenceException extends RuntimeException {
    public ScryfallPersistenceException(String message) {
        super(message);
    }

    public ScryfallPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
