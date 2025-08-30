package uz.pdp.AvtoTicket.dto.image;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.AvtoTicket.dto.BaseDTO;

@MultipartConfig(location = "/upload")
public record CreateImageDTO(
        MultipartFile file
) implements BaseDTO {
}
