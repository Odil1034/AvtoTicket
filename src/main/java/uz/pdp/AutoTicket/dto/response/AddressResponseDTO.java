package uz.pdp.AutoTicket.dto.response;

import uz.pdp.AutoTicket.dto.marker.Response;

public record AddressResponseDTO (
    Long id,
    String region,
    String city,
    String district,
    Double longitude,
    Double latitude
) implements Response {

}
