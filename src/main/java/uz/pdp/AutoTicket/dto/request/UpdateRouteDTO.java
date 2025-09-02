package uz.pdp.AutoTicket.dto.request;

import java.time.LocalTime;

import uz.pdp.AutoTicket.dto.marker.Request;

public record UpdateRouteDTO(
        CreateAddressDTO fromAddress,
        CreateAddressDTO toAddress,
        Double distance,
        LocalTime estimateTime) implements Request {

}
