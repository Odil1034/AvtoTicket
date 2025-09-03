package uz.pdp.AutoTicket.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uz.pdp.AutoTicket.dto.marker.Request;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 14:20
 */
public record UpdateDocumentDTO(
        @NotNull @NotBlank String fileName
) implements Request {
}
