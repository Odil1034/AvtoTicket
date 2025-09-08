package uz.pdp.AutoTicket.dto.request;

import uz.pdp.AutoTicket.dto.marker.Request;

public record UpdateAddressDTO(
        Long id,
        String region,
        String city,
        String district,
        Double latitude,
        Double longitude
) implements Request {

}
