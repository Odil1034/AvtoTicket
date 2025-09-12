package uz.pdp.avtoticket.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uz.pdp.avtoticket.dto.marker.Request;

/**
 * @author Baxriddinov Odiljon
 * @since 05/09/2025 09:53
 */
public record ChangePasswordDTO(
        @NotNull @NotBlank String oldPassword,
        @NotNull @NotBlank String newPassword
) implements Request {
}
