package uz.pdp.avtoticket.service;

import uz.pdp.avtoticket.dto.request.address.CreateCountryDTO;
import uz.pdp.avtoticket.dto.request.address.UpdateCountryDTO;
import uz.pdp.avtoticket.dto.response.address.CountryResponseDTO;
import uz.pdp.avtoticket.entity.address.Country;
import uz.pdp.avtoticket.service.markers.GenericCruidService;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 14:24
 */

public interface CountryService
        extends GenericCruidService<Long, Country, CountryResponseDTO, CreateCountryDTO, UpdateCountryDTO> {

    Country getCountryOrThrow(Long id);
}
