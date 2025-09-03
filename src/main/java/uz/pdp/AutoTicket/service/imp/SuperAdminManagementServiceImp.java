package uz.pdp.AutoTicket.service.imp;

import org.springframework.stereotype.Service;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.CreateRoleDTO;
import uz.pdp.AutoTicket.dto.response.RoleResponseDTO;
import uz.pdp.AutoTicket.dto.response.user.UserResponseDTO;
import uz.pdp.AutoTicket.dto.response.user.UserRolesDTO;
import uz.pdp.AutoTicket.service.SuperAdminManagementService;

import java.util.List;
import java.util.Set;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 21:35
 */

@Service
public class SuperAdminManagementServiceImp implements SuperAdminManagementService {

    @Override
    public Response<RoleResponseDTO> createRole(CreateRoleDTO dto) {
        return null;
    }

    @Override
    public Response<UserRolesDTO> assignRoleToUser(Long userId, String roleName) {
        return null;
    }

    @Override
    public Response<RoleResponseDTO> assignPermissionsToRole(Long roleId, Set<String> permissions) {
        return null;
    }

    @Override
    public Response<UserResponseDTO> updateUserRoles(Long userId, List<String> roles) {
        return null;
    }

    @Override
    public Set<String> getRoleNamesByUserId(Long userId) {
        return Set.of();
    }

    @Override
    public void addPermissionToRole(Long roleId, String permission) {

    }

    @Override
    public void updateRolePermissions(Long roleId, Set<String> permissions) {

    }

    @Override
    public Response<List<UserResponseDTO>> getAllUsers() {
        return null;
    }
}
