package uz.pdp.avtoticket.mapper;

import org.mapstruct.Mapper;
import uz.pdp.avtoticket.dto.response.DocumentResponseDTO;
import uz.pdp.avtoticket.entity.Document;

/**
 * @author Baxriddinov Odiljon
 * @since 12/09/2025 08:47
 */
@Mapper(componentModel = "spring")
public interface DocumentMapper extends uz.pdp.avtoticket.mapper.Mapper {

    Document toEntity(DocumentResponseDTO dto);
    DocumentResponseDTO toDTO(Document entity);
}
