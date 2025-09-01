package uz.pdp.AutoTicket.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;
import uz.pdp.AutoTicket.dto.marker.Response;
import uz.pdp.AutoTicket.enums.TokenType;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;


/**
 * @author Baxriddinov Odiljon
 * @since 31/08/2025 20:25
 */
@Validated
@JsonPropertyOrder({"user_id", "token_type", "access", "refresh"})
public record TokenResponseDTO(
        @JsonProperty("token_type")
        @NonNull TokenType tokenType,

        @JsonProperty("user_id")
        @NotNull Long userId,

        @NotNull TokenDTO access,

        @NotNull TokenDTO refresh) implements Response {
    public static TokenResponseDTO of(Long userId, TokenDTO access, TokenDTO refresh) {
        return new TokenResponseDTO(TokenType.BEARER, userId, access, refresh);
    }
}
