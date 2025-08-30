package uz.pdp.AvtoTicket.dto.address;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.AvtoTicket.dto.BaseDTO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponseDTO implements BaseDTO {
    private Long id;
    @NotNull
    private String region;
    @NotNull
    private String city;
    @NotNull
    private String district;

    Double longitude;   // optional
    Double latitude;
}
