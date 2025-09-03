package uz.pdp.AutoTicket.dto.response.user;

import uz.pdp.AutoTicket.dto.marker.Response;
import uz.pdp.AutoTicket.entity.Role;

import java.util.Set;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 16:15
 */
public record UserRolesDTO(
        Long userId,
        Set<Role> userRoles
) implements Response {

}
