package uz.pdp.AvtoTicket.dto.response;

import uz.pdp.AvtoTicket.dto.BaseDTO;

public record AddressDTO(
        Long id,
        String region,
        String city,
        String district,

        Double longitude,   // optional
        Double latitude
) implements BaseDTO {

}
