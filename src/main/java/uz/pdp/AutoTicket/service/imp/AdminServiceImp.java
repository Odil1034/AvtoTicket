package uz.pdp.AutoTicket.service.imp;

import org.springframework.stereotype.Service;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.CreateRoleDTO;
import uz.pdp.AutoTicket.dto.response.RoleResponseDTO;
import uz.pdp.AutoTicket.dto.response.user.BlockUserDTO;
import uz.pdp.AutoTicket.dto.response.user.UserRolesDTO;
import uz.pdp.AutoTicket.service.AdminService;

import java.util.Set;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 16:29
 */

@Service
public class AdminServiceImp implements AdminService {

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
    public Response<BlockUserDTO> blockUser(Long userId) {
        return null;
    }

    @Override
    public Response<BlockUserDTO> unblockUser(Long userId) {
        return null;
    }
}
