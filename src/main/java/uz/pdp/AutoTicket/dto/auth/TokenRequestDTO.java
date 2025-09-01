package uz.pdp.AutoTicket.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uz.pdp.AutoTicket.dto.marker.Request;

/**
 * @author Baxriddinov Odiljon
 * @since 31/08/2025 20:25
 */

public record TokenRequestDTO(
        @NotBlank @NotNull String username,
        @NotBlank @NotNull String password
) implements Request {
}
