package org.MustacheTeam.MagicTrade.exception;

public class ScryfallPersistenceException extends RuntimeException {
    public ScryfallPersistenceException(String message) {
        super(message);
    }

    public ScryfallPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
