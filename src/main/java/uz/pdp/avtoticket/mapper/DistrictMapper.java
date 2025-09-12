package uz.pdp.avtoticket.mapper;

import org.mapstruct.Mapper;
import uz.pdp.avtoticket.dto.request.address.CreateDistrictDTO;
import uz.pdp.avtoticket.dto.request.address.UpdateDistrictDTO;
import uz.pdp.avtoticket.dto.response.address.DistrictResponseDTO;
import uz.pdp.avtoticket.entity.address.District;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 15:05
 */

@Mapper(componentModel = "spring")
public interface DistrictMapper
        extends GenericMapper<District, DistrictResponseDTO, CreateDistrictDTO, UpdateDistrictDTO> {

}
