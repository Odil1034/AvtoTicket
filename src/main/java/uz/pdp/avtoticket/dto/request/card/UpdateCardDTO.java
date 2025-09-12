package uz.pdp.avtoticket.dto.request.card;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uz.pdp.avtoticket.dto.marker.Request;

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
