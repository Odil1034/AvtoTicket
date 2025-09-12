package uz.pdp.avtoticket.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.address.CreateDistrictDTO;
import uz.pdp.avtoticket.dto.request.address.UpdateDistrictDTO;
import uz.pdp.avtoticket.dto.response.address.DistrictResponseDTO;
import uz.pdp.avtoticket.dto.response.address.RegionResponseDTO;
import uz.pdp.avtoticket.entity.address.District;
import uz.pdp.avtoticket.service.markers.GenericCruidService;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 15:11
 */

public interface DistrictService
        extends GenericCruidService<Long, District, DistrictResponseDTO, CreateDistrictDTO, UpdateDistrictDTO> {

    Response<Void> createAll(@Valid List<CreateDistrictDTO> dto);

    Response<List<DistrictResponseDTO>> findAllByRegionId(@NotNull Long regionId);
}
