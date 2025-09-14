package uz.pdp.avtoticket.dto.request;

import uz.pdp.avtoticket.dto.marker.Request;
import uz.pdp.avtoticket.dto.request.address.CreateAddressDTO;

public record CreateRouteDTO(
        CreateAddressDTO fromAddress,
        CreateAddressDTO toAddress
) implements Request {
}
