package uz.pdp.AvtoTicket.dto.response;

import uz.pdp.AvtoTicket.dto.BaseDTO;
import java.util.List;

public record UserDTO(
        Long id,
        String username,
        String email,
        String phoneNumber,
        List<String> roles
) implements BaseDTO {
}
