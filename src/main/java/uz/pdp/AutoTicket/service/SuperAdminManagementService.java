package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.CreateRoleDTO;
import uz.pdp.AutoTicket.dto.response.RoleResponseDTO;
import uz.pdp.AutoTicket.dto.response.user.UserResponseDTO;
import uz.pdp.AutoTicket.dto.response.user.UserRolesDTO;
import uz.pdp.AutoTicket.service.markers.GenericService;

import java.util.List;
import java.util.Set;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 21:31
 */
public interface SuperAdminManagementService extends GenericService {

    // yangi rol yaratish.
    Response<RoleResponseDTO> createRole(CreateRoleDTO dto);

    // userga rol biriktirish.
    Response<UserRolesDTO> assignRoleToUser(Long userId, String roleName);

    // rolega permission qo‘shish.
    Response<RoleResponseDTO> assignPermissionsToRole(Long roleId, Set<String> permissions);

    // Userning role(larini) yangilash
    Response<UserResponseDTO> updateUserRoles(Long userId, List<String> roles);

    // Foydalanuvchining role nomlarini olish
    Set<String> getRoleNamesByUserId(Long userId);

    // Rolega permission qo‘shish
    void addPermissionToRole(Long roleId, String permission);

    // Role permissionlarini yangilash
    void updateRolePermissions(Long roleId, Set<String> permissions);

    // Barcha userlarni olish
    Response<List<UserResponseDTO>> getAllUsers();

}
