package uz.pdp.avtoticket.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uz.pdp.avtoticket.dto.marker.Request;
import uz.pdp.avtoticket.enums.Gender;

public record UserUpdateDTO(
        @NotNull @NotBlank String username,
        @NotNull @NotBlank String firstName,
        @NotNull @NotBlank String lastName,
        @NotNull LocalDate dateOfBirth,
        @NotNull @NotBlank String passportNumber,
        @NotNull @NotBlank String email,
        @NotNull @NotBlank String phoneNumber,
        Gender gender
) implements Request {
}
