package uz.pdp.AutoTicket.mapper;

import org.mapstruct.Mapper;

import uz.pdp.AutoTicket.dto.role.CreateRoleDTO;
import uz.pdp.AutoTicket.dto.role.RoleResponseDTO;
import uz.pdp.AutoTicket.dto.role.UpdateRoleDTO;
import uz.pdp.AutoTicket.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper
        extends GenericMapper<Role, RoleResponseDTO, CreateRoleDTO, UpdateRoleDTO> {
}
