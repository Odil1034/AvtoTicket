package uz.pdp.AvtoTicket.dto.response;

import uz.pdp.AvtoTicket.dto.BaseDTO;

public record ImageDTO(
        Long id,
        String url,
        String fileName,
        String generatedName,
        String extension,
        String mimeType
) implements BaseDTO {
}
