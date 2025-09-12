package uz.pdp.avtoticket.mapper;

import org.mapstruct.Mapper;

import uz.pdp.avtoticket.dto.request.CreateRoleDTO;
import uz.pdp.avtoticket.dto.request.UpdateRoleDTO;
import uz.pdp.avtoticket.dto.response.RoleResponseDTO;
import uz.pdp.avtoticket.entity.Role;

@Mapper(componentModel = "spring", uses = PermissionMapper.class)
public interface RoleMapper
        extends GenericMapper<Role, RoleResponseDTO, CreateRoleDTO, UpdateRoleDTO> {

}
