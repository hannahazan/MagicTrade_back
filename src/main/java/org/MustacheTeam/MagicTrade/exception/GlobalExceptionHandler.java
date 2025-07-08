package org.MustacheTeam.MagicTrade.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

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

    // 500 - unexpected internal errors (catch-all)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, HttpServletRequest request) {
        return buildError(
                "INTERNAL_ERROR",
                "Well, that wasn't supposed to happen. The tech goblins are on it !",
                HttpStatus.INTERNAL_SERVER_ERROR,
                request
        );
    }

    // 400 - validation failed in @RequestBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> e.getField() + " : " + e.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return buildError("VALIDATION_FAILED", errorMessage, HttpStatus.BAD_REQUEST, request);
    }

    // 400 - validation failed in @RequestParam, @PathVariable
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolation(ConstraintViolationException ex, HttpServletRequest request) {
        String errorMessage = ex.getConstraintViolations().stream()
                .map(v -> v.getPropertyPath() + " : " + v.getMessage())
                .collect(Collectors.joining(", "));
        return buildError("INVALID_PARAMETER", errorMessage, HttpStatus.BAD_REQUEST, request);
    }

    // 400 - URL parameter type error
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleTypeMismatch(MethodArgumentTypeMismatchException ex, HttpServletRequest request) {
        String expectedType = (ex.getRequiredType() == null)
                ? "unknown"
                : ex.getRequiredType().getSimpleName();

        String message = "Parameter '" + ex.getName() + "' must be of type " + expectedType;
        return buildError("TYPE_MISMATCH", message, HttpStatus.BAD_REQUEST, request);
    }

    // 404 - resource not found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
        return buildError("RESOURCE_NOT_FOUND", ex.getMessage(), HttpStatus.NOT_FOUND, request);
    }

    // 502 - failed contacting scryfall API
    @ExceptionHandler(ScryfallApiException.class)
    public ResponseEntity<ErrorResponse> handleScryfallApi(ScryfallApiException ex, HttpServletRequest request) {
        String message = "Error during Scryfall API call - " + ex.getMessage();
        return buildError(
                "SCRYFALL_API_ERROR",
                message,
                HttpStatus.BAD_GATEWAY,
                request
        );
    }

    // 500 - failed saving scryfall data in database
    @ExceptionHandler(ScryfallPersistenceException.class)
    public ResponseEntity<ErrorResponse> handleScryfallPersistence(ScryfallPersistenceException ex, HttpServletRequest request) {
        return buildError(
                "SCRYFALL_PERSISTENCE_ERROR",
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                request
        );
    }

}
