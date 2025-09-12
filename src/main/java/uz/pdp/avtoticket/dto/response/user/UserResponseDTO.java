package uz.pdp.avtoticket.dto.response.user;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import uz.pdp.avtoticket.dto.marker.Response;
import uz.pdp.avtoticket.dto.response.OrderResponseDTO;
import uz.pdp.avtoticket.dto.response.RoleResponseDTO;
import uz.pdp.avtoticket.enums.Gender;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserResponseDTO(
        Long id,
        String username,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        LocalDate dateOfBirth,
        String passportNumber,
        Gender gender,
        Set<RoleResponseDTO> roles
//        List<OrderResponseDTO> orders
) implements Response {
}
