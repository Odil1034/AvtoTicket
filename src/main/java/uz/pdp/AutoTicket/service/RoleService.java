package uz.pdp.AutoTicket.service;

import org.springframework.stereotype.Service;

import uz.pdp.AutoTicket.dto.request.CreateRoleDTO;
import uz.pdp.AutoTicket.dto.request.UpdateRoleDTO;
import uz.pdp.AutoTicket.dto.response.RoleResponseDTO;
import uz.pdp.AutoTicket.entity.Role;
import uz.pdp.AutoTicket.service.markers.GenericCruidService;

import java.util.Set;

@Service
public interface RoleService
        extends GenericCruidService<Long, Role, RoleResponseDTO, CreateRoleDTO, UpdateRoleDTO> {

    String getRoleStr(Set<Role> roles);
}
