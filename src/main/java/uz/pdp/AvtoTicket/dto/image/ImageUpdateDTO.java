package uz.pdp.AvtoTicket.dto.image;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.AvtoTicket.dto.BaseDTO;

@MultipartConfig(location = "/upload")
public record ImageUpdateDTO(
        String url,
        String fileName,
        @RequestPart MultipartFile file
) implements BaseDTO {
}
