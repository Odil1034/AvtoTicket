package uz.pdp.AutoTicket.mapper;

import org.mapstruct.Mapper;

import uz.pdp.AutoTicket.dto.request.CreateRoleDTO;
import uz.pdp.AutoTicket.dto.request.UpdateRoleDTO;
import uz.pdp.AutoTicket.dto.response.RoleResponseDTO;
import uz.pdp.AutoTicket.entity.Role;

@Mapper(componentModel = "spring", uses = PermissionMapper.class)
public interface RoleMapper
        extends GenericMapper<Role, RoleResponseDTO, CreateRoleDTO, UpdateRoleDTO> {

}
