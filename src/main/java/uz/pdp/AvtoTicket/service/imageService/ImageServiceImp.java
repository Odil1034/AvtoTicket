package uz.pdp.AvtoTicket.service.imageService;

import org.springframework.stereotype.Service;
import uz.pdp.AvtoTicket.dto.response.ImageDTO;
import uz.pdp.AvtoTicket.dto.request.create.CreateImageDTO;
import uz.pdp.AvtoTicket.dto.request.update.ImageUpdateDTO;
import uz.pdp.AvtoTicket.entity.image.Image;

import java.util.List;

@Service
public class ImageServiceImp implements ImageService {
    @Override
    public Image uploadFile(CreateImageDTO dto) {
        return null;
    }

    @Override
    public ImageDTO downloadImage(String generatedName) {
        return null;
    }

    @Override
    public ImageDTO create(CreateImageDTO dto) {
        return null;
    }

    @Override
    public ImageDTO getById(Long id) {
        return null;
    }

    @Override
    public List<ImageDTO> getAll() {
        return List.of();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public ImageDTO update(Long id, ImageUpdateDTO dto) {
        return null;
    }

    @Override
    public Image findById(Long id) {
        return null;
    }
}
