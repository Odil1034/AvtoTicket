package uz.pdp.avtoticket.dto.response;

import uz.pdp.avtoticket.dto.marker.Response;
import uz.pdp.avtoticket.dto.response.address.DistrictResponseDTO;

public record RouteResponseDTO(
        Long id,
        String name,
        DistrictResponseDTO fromAddress,
        DistrictResponseDTO toAddress,
        Double distance,
        String estimateTime
) implements Response {

}
