package uz.pdp.AvtoTicket.dto.address;

import uz.pdp.AvtoTicket.dto.BaseDTO;

public record CreateAddressDTO(
        String region,
        String city,
        String district,

        Double longitude,   // optional
        Double latitude
) implements BaseDTO {

}
