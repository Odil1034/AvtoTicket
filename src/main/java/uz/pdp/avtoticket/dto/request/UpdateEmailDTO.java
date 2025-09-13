package uz.pdp.avtoticket.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

/**
 * @author Baxriddinov Odiljon
 * @since 13/09/2025 11:15
 */
public record UpdateEmailDTO(
        @NotNull
        @Email(message = "Email format is invalid")
        String email
) {
}
