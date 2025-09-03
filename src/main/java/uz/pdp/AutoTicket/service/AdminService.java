package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.CreateRoleDTO;
import uz.pdp.AutoTicket.dto.response.RoleResponseDTO;
import uz.pdp.AutoTicket.dto.response.user.BlockUserDTO;
import uz.pdp.AutoTicket.dto.response.user.UserRolesDTO;
import uz.pdp.AutoTicket.entity.Role;
import uz.pdp.AutoTicket.service.markers.GenericService;

import java.util.Set;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 16:29
 */
public interface AdminService extends GenericService {

    // yangi rol yaratish.
    Response<RoleResponseDTO> createRole(CreateRoleDTO dto);

    // userga rol biriktirish.
    Response<UserRolesDTO> assignRoleToUser(Long userId, String roleName);

    // rolega permission qo‘shish.
    Response<RoleResponseDTO> assignPermissionsToRole(Long roleId, Set<String> permissions);

    // userni bloklash.
    Response<BlockUserDTO> blockUser(Long userId);

    // unblock user
    Response<BlockUserDTO> unblockUser(Long userId);

}
