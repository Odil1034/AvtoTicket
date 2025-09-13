package uz.pdp.avtoticket.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import uz.pdp.avtoticket.dto.marker.Request;
import uz.pdp.avtoticket.dto.request.address.CreateAddressDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UpdateRouteDTO(
        Long id,
        CreateAddressDTO fromAddress,
        CreateAddressDTO toAddress
) implements Request {

}
