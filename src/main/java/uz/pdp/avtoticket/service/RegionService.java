package uz.pdp.avtoticket.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.address.UpdateRegionDTO;
import uz.pdp.avtoticket.dto.request.address.CreateRegionDTO;
import uz.pdp.avtoticket.dto.response.address.RegionResponseDTO;
import uz.pdp.avtoticket.entity.address.Region;
import uz.pdp.avtoticket.service.markers.GenericCruidService;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 14:27
 */
public interface RegionService
        extends GenericCruidService<Long, Region, RegionResponseDTO, CreateRegionDTO, UpdateRegionDTO> {

    Response<List<RegionResponseDTO>> createAll(@Valid List<CreateRegionDTO> dto);

}
