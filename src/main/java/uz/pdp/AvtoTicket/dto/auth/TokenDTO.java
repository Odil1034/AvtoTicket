package uz.pdp.AvtoTicket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uz.pdp.AvtoTicket.dto.marker.Response;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Baxriddinov Odiljon
 * @since 31/08/2025 20:10
 */

@JsonPropertyOrder({"token", "issuedAt", "expiredAt", "expiresIn"})
public record TokenDTO(
        @JsonProperty("token")
        @NotBlank @NotNull String token,

        @JsonProperty("expiredAt")
        @NotNull LocalDateTime expiredAt,

        @JsonProperty("issuedAt")
        @NotNull LocalDateTime issuedAt,

        @JsonProperty("expiresIn")
        @NotNull Long expiresIn
) implements Response {
}
