package uz.pdp.avtoticket.dto.response.card;

import com.fasterxml.jackson.annotation.JsonInclude;
import uz.pdp.avtoticket.dto.marker.Response;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 13:24
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CardResponseDTO(
        Long id,
        String name,
        String cardName,
        String holderName,
        String cardNumber,
        String expiredDate
) implements Response {

}