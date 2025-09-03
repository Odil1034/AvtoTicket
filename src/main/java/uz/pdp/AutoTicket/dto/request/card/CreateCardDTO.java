package uz.pdp.AutoTicket.dto.request.card;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import uz.pdp.AutoTicket.dto.marker.Request;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 13:35
 */
public record CreateCardDTO(
        @NotNull
        @NotBlank
        String name,

        @NotBlank
        @Pattern(
                regexp = "^(?=.{2,50}$)[\\p{L}]+(?:[ '\\-][\\p{L}]+)*$",
                message = "Invalid card holder name"
        )
        String holderName,

        @NotBlank
        @Pattern(
                regexp = "^\\d{13,19}$",
                message = "Card number must be 13-19 digits"
        )
        String cardNumber,

        @NotBlank
        @Pattern(
                regexp = "^(0[1-9]|1[0-2])\\/\\d{2}$",
                message = "Expiry date must be in MM/YY format"
        )
        String expiredDate
) implements Request {
}
