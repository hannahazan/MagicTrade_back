package org.MustacheTeam.MagicTrade.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

        @Email(message = "The email address is not valid")
        @NotBlank(message = "Email is required")
        private String email;

        @NotBlank(message = "Password is required")
        @Size(min = 12, message = "Password must be at least 12 characters long")
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*#?&]).{12,}$",
                message = "Password must contain an uppercase letter, a lowercase letter, a number, and a special character"
        )
        private String password;

        @NotBlank(message = "Username is required")
        @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
        private String pseudo;

        @NotBlank(message = "Last name is required")
        @Size(max = 15, message = "Last name must not exceed 15 characters")
        private String firstName;

        @NotBlank(message = "First name is required")
        @Size(max = 15, message = "First name must not exceed 15 characters")
        private String lastName;

        @NotBlank(message = "Country is required")
        @Size(max = 30, message = "Country must not exceed 30 characters")
        private String country;

        @NotBlank(message = "Department is required")
        @Size(max = 30, message = "Department must not exceed 30 characters")
        private String department;

        @NotBlank(message = "City is required")
        @Size(max = 30, message = "City must not exceed 30 characters")
        private String city;

        public UserDto(String email, String pseudo, String firstName, String lastName, String country, String department, String city, String password) {
                this.email = email;
                this.pseudo = pseudo;
                this.firstName = firstName;
                this.lastName = lastName;
                this.country = country;
                this.department = department;
                this.city = city;
                this.password = password;
        }
}
