package uz.pdp.avtoticket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.pdp.avtoticket.dto.request.address.UpdateRegionDTO;
import uz.pdp.avtoticket.dto.request.address.CreateRegionDTO;
import uz.pdp.avtoticket.dto.response.address.RegionResponseDTO;
import uz.pdp.avtoticket.entity.address.Region;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 15:04
 */
@Mapper(componentModel = "spring", uses = CountryMapper.class)
public interface RegionMapper extends GenericMapper<Region, RegionResponseDTO, CreateRegionDTO, UpdateRegionDTO> {

    @Override
    @Mapping(target = "countryId", expression = "java(entity.getCountry().getId())")
    RegionResponseDTO toDto(Region entity);
}
