package uz.pdp.AvtoTicket.service.imageService;

import uz.pdp.AvtoTicket.dto.response.ImageDTO;
import uz.pdp.AvtoTicket.dto.request.create.CreateImageDTO;
import uz.pdp.AvtoTicket.dto.request.update.ImageUpdateDTO;
import uz.pdp.AvtoTicket.entity.image.Image;
import uz.pdp.AvtoTicket.service.BaseService;

public interface ImageService extends BaseService<Image, CreateImageDTO, ImageUpdateDTO, ImageDTO> {
    Image uploadFile(CreateImageDTO dto);
    ImageDTO downloadImage(String generatedName);
}
