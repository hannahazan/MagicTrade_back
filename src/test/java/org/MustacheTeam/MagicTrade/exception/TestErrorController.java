package org.MustacheTeam.MagicTrade.exception;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test-error")
@Validated
public class TestErrorController {

    @GetMapping("/not-found")
    public void triggerNotFound() {
        throw new ResourceNotFoundException("Resource not found");
    }

    @GetMapping("/validation-error")
    public void triggerValidation(@RequestBody @Valid DummyRequest dummy) {
        // requires not valid request body to trigger
    }

    @GetMapping("/constraint-violation")
    public void triggerConstraintViolation(@RequestParam @Min(1) int id) {
        // requires not valid request param to trigger
    }

    @GetMapping("/type-mismatch")
    public void triggerTypeMismatch(@RequestParam int value) {
        // requires a wrong type to trigger
    }

    @GetMapping("/unexpected")
    public void triggerUnexpected() {
        throw new RuntimeException("Unexpected error");
    }

    @GetMapping("/scryfall-api")
    public void triggerScryfallApi() {
        throw new ScryfallApiException("Simulated Scryfall API failure");
    }

    @GetMapping("/scryfall-persistence")
    public void triggerScryfallPersistence() {
        throw new ScryfallPersistenceException("Simulated Scryfall persistence error");
    }

    public static class DummyRequest {
        @NotBlank
        private String name;
    }
}
