package org.MustacheTeam.MagicTrade.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 500 - unexpected internal errors
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, HttpServletRequest request) {
        return buildError(
                "INTERNAL_ERROR",
                "Well, that wasn't supposed to happen. The tech goblins are on it !",
                HttpStatus.INTERNAL_SERVER_ERROR,
                request
        );
    }

    // 404 - generic not found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
        return buildError(
                "RESOURCE_NOT_FOUND",
                ex.getMessage(),
                HttpStatus.NOT_FOUND,
                request
        );
    }

    private ResponseEntity<ErrorResponse> buildError(
            String code,
            String message,
            HttpStatus status,
            HttpServletRequest request
    ) {
        ErrorResponse error = new ErrorResponse(
                code,
                message,
                status.value(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(error);
    }
}
