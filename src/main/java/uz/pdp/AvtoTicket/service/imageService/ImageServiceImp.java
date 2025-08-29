package uz.pdp.AvtoTicket.service.imageService;

import org.springframework.stereotype.Service;
import uz.pdp.AvtoTicket.dto.image.ImageResponseDTO;
import uz.pdp.AvtoTicket.dto.image.CreateImageDTO;
import uz.pdp.AvtoTicket.dto.image.ImageUpdateDTO;
import uz.pdp.AvtoTicket.entity.image.Image;

import java.util.List;

@Service
public class ImageServiceImp implements ImageService {
    @Override
    public Image uploadFile(CreateImageDTO dto) {
        return null;
    }

    @Override
    public ImageResponseDTO downloadImage(String generatedName) {
        return null;
    }

    @Override
    public ImageResponseDTO create(CreateImageDTO dto) {
        return null;
    }

    @Override
    public ImageResponseDTO getById(Long id) {
        return null;
    }

    @Override
    public List<ImageResponseDTO> getAll() {
        return List.of();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public ImageResponseDTO update(Long id, ImageUpdateDTO dto) {
        return null;
    }

    @Override
    public Image findById(Long id) {
        return null;
    }
}
