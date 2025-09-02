package uz.pdp.AutoTicket.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import uz.pdp.AutoTicket.dto.marker.Response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Baxriddinov Odiljon
 * @since 31/08/2025 17:54
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse(
        String code,
        String uri,
        String url,
        String reason,
        String message,
        LocalDateTime timestamp
) implements Response {

    public static ErrorResponse of(String code, String uri, String url, String reason, String message) {
        return new ErrorResponse(
                code,
                uri,
                url,
                reason,
                message,
                LocalDateTime.now()
                );
    }

    public String getTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timestamp.format(formatter);
    }

}
