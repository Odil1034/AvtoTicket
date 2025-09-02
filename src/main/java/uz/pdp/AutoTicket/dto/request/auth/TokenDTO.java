package uz.pdp.AutoTicket.dto.request.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uz.pdp.AutoTicket.dto.marker.Response;

import java.time.LocalDateTime;

/**
 * @author Baxriddinov Odiljon
 * @since 31/08/2025 20:10
 */

@JsonPropertyOrder({"token", "issuedAt", "expiredAt", "expiresIn"})
public record TokenDTO(
        @JsonProperty("token")
        @NotBlank @NotNull String token,

        @JsonProperty("issuedAt")
        @NotNull LocalDateTime issuedAt,

        @JsonProperty("expiredAt")
        @NotNull LocalDateTime expiredAt,

        @JsonProperty("expiresIn")
        @NotNull Long expiresIn
) implements Response {
}
