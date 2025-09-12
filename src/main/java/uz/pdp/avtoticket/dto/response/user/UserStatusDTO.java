package uz.pdp.avtoticket.dto.response.user;

import uz.pdp.avtoticket.dto.marker.Response;
import uz.pdp.avtoticket.enums.UserStatus;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 16:12
 */
public record UserStatusDTO(
        Long userId,
        UserStatus status
) implements Response {
}
