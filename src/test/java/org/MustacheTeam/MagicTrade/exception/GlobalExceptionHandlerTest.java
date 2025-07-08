package org.MustacheTeam.MagicTrade.exception;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers= TestErrorController.class)
class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testResourceNotFound() throws Exception {
        mockMvc.perform(get("/test-error/not-found"))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.code").value("RESOURCE_NOT_FOUND"))
            .andExpect(jsonPath("$.message").value("Resource not found"));
    }

    @Test
    void testUnexpectedError() throws Exception {
        mockMvc.perform(get("/test-error/unexpected"))
            .andExpect(status().isInternalServerError())
            .andExpect(jsonPath("$.code").value("INTERNAL_ERROR"))
            .andExpect(jsonPath("$.message").exists());
    }

    @Test
    void testConstraintViolation() throws Exception {
        mockMvc.perform(get("/test-error/constraint-violation?id=0"))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.code").value("INVALID_PARAMETER"))
            .andExpect(jsonPath("$.message").value(Matchers.containsString("id")));
    }

    @Test
    void testTypeMismatch() throws Exception {
        mockMvc.perform(get("/test-error/type-mismatch?value=abc"))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.code").value("TYPE_MISMATCH"))
            .andExpect(jsonPath("$.message").value(Matchers.containsString("Parameter 'value' must be of type")));
    }

    @Test
    void testValidationError() throws Exception {
        String json = "{}";

        mockMvc.perform(get("/test-error/validation-error")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.code").value("VALIDATION_FAILED"))
            .andExpect(jsonPath("$.message").value(Matchers.containsString("name")));
    }

    @Test
    void testScryfallApiException() throws Exception {
        mockMvc.perform(get("/test-error/scryfall-api"))
                .andExpect(status().isBadGateway())
                .andExpect(jsonPath("$.code").value("SCRYFALL_API_ERROR"))
                .andExpect(jsonPath("$.message").value(Matchers.containsString("Simulated Scryfall API failure")));
    }

    @Test
    void testScryfallPersistenceError() throws Exception {
        mockMvc.perform(get("/test-error/scryfall-persistence"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.code").value("SCRYFALL_PERSISTENCE_ERROR"))
                .andExpect(jsonPath("$.message").value(Matchers.containsString("Simulated Scryfall persistence error")));
    }
}
