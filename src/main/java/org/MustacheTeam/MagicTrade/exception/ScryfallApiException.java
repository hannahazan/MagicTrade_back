package org.MustacheTeam.MagicTrade.exception;

public class ScryfallApiException extends RuntimeException {
    public ScryfallApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScryfallApiException(String message) {
        super(message);
    }
}
