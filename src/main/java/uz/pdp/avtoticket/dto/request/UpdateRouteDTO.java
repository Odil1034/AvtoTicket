package uz.pdp.avtoticket.dto.request;

import java.time.LocalTime;

import uz.pdp.avtoticket.dto.marker.Request;
import uz.pdp.avtoticket.dto.request.address.CreateDistrictDTO;

public record UpdateRouteDTO(
        Long id,
        CreateDistrictDTO fromAddress,
        CreateDistrictDTO toAddress,
        Double fromLongitude,
        Double fromLatitude,
        Double toLongitude,
        Double toLatitude
) implements Request {

}
