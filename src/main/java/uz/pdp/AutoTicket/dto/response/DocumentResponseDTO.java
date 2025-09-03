package uz.pdp.AutoTicket.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import uz.pdp.AutoTicket.dto.marker.Response;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 11:31
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "file_url", "fileName", "generatedName", "extension", "size"})
public record DocumentResponseDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("url")
        String url,
        @JsonProperty("generatedName")
        String generatedName,
        @JsonProperty("fileName")
        String fileName,
        @JsonProperty("extension")
        String extension,
        @JsonProperty("size")
        Double size
) implements Response {
}
