package uz.pdp.AutoTicket.dto.request;

import uz.pdp.AutoTicket.dto.marker.Request;

public record UpdateAddressDTO(
    String region,
    String city,
    String district,
    Double latitute,
    Double longitute
) implements Request {

}
