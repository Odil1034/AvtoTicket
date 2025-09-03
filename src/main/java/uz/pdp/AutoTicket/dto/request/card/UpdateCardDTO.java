package uz.pdp.AutoTicket.dto.request.card;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uz.pdp.AutoTicket.dto.marker.Request;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 13:44
 */
public record UpdateCardDTO(
        @NotNull
        @NotBlank
        String name
) implements Request {
}
