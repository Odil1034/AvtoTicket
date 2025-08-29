package uz.pdp.AvtoTicket.service.imageService;

import uz.pdp.AvtoTicket.dto.image.ImageResponseDTO;
import uz.pdp.AvtoTicket.dto.image.CreateImageDTO;
import uz.pdp.AvtoTicket.dto.image.ImageUpdateDTO;
import uz.pdp.AvtoTicket.entity.image.Image;
import uz.pdp.AvtoTicket.service.BaseService;

public interface ImageService extends BaseService<Image, CreateImageDTO, ImageUpdateDTO, ImageResponseDTO> {
    Image uploadFile(CreateImageDTO dto);
    ImageResponseDTO downloadImage(String generatedName);
}
