package uz.pdp.AvtoTicket.dto.image;

import uz.pdp.AvtoTicket.dto.BaseDTO;

public record ImageResponseDTO(
        Long id,
        String url,
        String fileName,
        String generatedName,
        String extension,
        String mimeType
) implements BaseDTO {
}
