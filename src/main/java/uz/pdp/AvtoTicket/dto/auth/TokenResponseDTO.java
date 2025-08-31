package uz.pdp.AvtoTicket.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import uz.pdp.AvtoTicket.dto.marker.Response;
import uz.pdp.AvtoTicket.enums.TokenType;

@Validated
@JsonPropertyOrder({"user_id", "token_type", "access", "refresh", "_links"})
public record TokenResponseDTO(String email, String password) implements Response {

    @JsonProperty("token_type")
    @NonNull
    TokenType tokenType;
    @JsonProperty("user_id")
    @NonNull Long userId;
}
