package uz.pdp.AutoTicket.dto.response;

import java.time.LocalTime;

import uz.pdp.AutoTicket.dto.marker.Response;

public record RouteResponseDTO(
        Long id,
        String name,
        AddressResponseDTO fromAddress,
        AddressResponseDTO toAddress,
        Double distance,
        LocalTime estimateTime
) implements Response {

}
