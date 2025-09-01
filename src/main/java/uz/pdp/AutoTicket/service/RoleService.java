package uz.pdp.AutoTicket.service;

import org.springframework.stereotype.Service;

import uz.pdp.AutoTicket.dto.role.CreateRoleDTO;
import uz.pdp.AutoTicket.dto.role.RoleResponseDTO;
import uz.pdp.AutoTicket.dto.role.UpdateRoleDTO;
import uz.pdp.AutoTicket.entity.Role;

@Service
public interface RoleService
        extends GenericCruidService<Long, Role, RoleResponseDTO, CreateRoleDTO, UpdateRoleDTO> {
}
