package org.MustacheTeam.MagicTrade.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse {
    private String code;
    private String message;
    private int status;
    private String path;
    private LocalDateTime timestamp;

    public ErrorResponse(String code, String message, int status, String path) {
        this.code = code;
        this.message = message;
        this.status = status;
        this.path = path;
        this.timestamp = LocalDateTime.now();
    }
}

