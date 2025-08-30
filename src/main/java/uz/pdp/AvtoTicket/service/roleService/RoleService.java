package uz.pdp.AvtoTicket.service.roleService;

import org.springframework.stereotype.Service;
import uz.pdp.AvtoTicket.dto.request.create.CreateRoleDTO;
import uz.pdp.AvtoTicket.dto.response.RoleDTO;
import uz.pdp.AvtoTicket.dto.request.update.UpdateRoleDTO;
import uz.pdp.AvtoTicket.entity.role.Role;
import uz.pdp.AvtoTicket.service.BaseService;

@Service
public interface RoleService extends BaseService<Role, CreateRoleDTO, UpdateRoleDTO, RoleDTO> {
}
