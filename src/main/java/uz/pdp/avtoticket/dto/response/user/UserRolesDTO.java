package uz.pdp.avtoticket.dto.response.user;

import uz.pdp.avtoticket.dto.marker.Response;
import uz.pdp.avtoticket.entity.Role;

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
