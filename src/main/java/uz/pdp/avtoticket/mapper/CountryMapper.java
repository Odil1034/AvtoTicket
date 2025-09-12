package uz.pdp.avtoticket.mapper;

import org.mapstruct.Mapper;
import uz.pdp.avtoticket.dto.request.address.CreateCountryDTO;
import uz.pdp.avtoticket.dto.request.address.UpdateCountryDTO;
import uz.pdp.avtoticket.dto.response.address.CountryResponseDTO;
import uz.pdp.avtoticket.entity.address.Country;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 14:50
 */
@Mapper(componentModel = "spring")
public interface CountryMapper
        extends GenericMapper<Country, CountryResponseDTO, CreateCountryDTO, UpdateCountryDTO> {
}
