package uz.pdp.avtoticket.dto.response;

import java.time.LocalTime;

import uz.pdp.avtoticket.dto.marker.Response;
import uz.pdp.avtoticket.dto.response.address.DistrictResponseDTO;

public record RouteResponseDTO(
        Long id,
        String name,
        DistrictResponseDTO fromAddress,
        DistrictResponseDTO toAddress,
        Double longitude,
        Double latitude,
        Double distance,
        LocalTime estimateTime
) implements Response {

}
