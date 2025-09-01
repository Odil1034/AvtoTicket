package uz.pdp.AvtoTicket.service.roleService;

import org.springframework.stereotype.Service;
import uz.pdp.AvtoTicket.dto.role.CreateRoleDTO;
import uz.pdp.AvtoTicket.dto.role.RoleResponseDTO;
import uz.pdp.AvtoTicket.dto.role.UpdateRoleDTO;
import uz.pdp.AvtoTicket.entity.role.Role;

@Service
public interface RoleService extends BaseService<Role, CreateRoleDTO, UpdateRoleDTO, RoleResponseDTO> {
}
