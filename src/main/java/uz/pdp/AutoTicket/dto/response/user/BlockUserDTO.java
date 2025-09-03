package uz.pdp.AutoTicket.dto.response.user;

import uz.pdp.AutoTicket.dto.marker.Response;
import uz.pdp.AutoTicket.enums.UserStatus;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 16:12
 */
public record BlockUserDTO(
        Long userId,
        UserStatus status
) implements Response {
}
