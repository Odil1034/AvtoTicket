package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import uz.pdp.AvtoTicket.dto.request.create.CreateRoleDTO;
import uz.pdp.AvtoTicket.dto.response.RoleDTO;
import uz.pdp.AvtoTicket.dto.request.update.UpdateRoleDTO;
import uz.pdp.AvtoTicket.entity.role.Role;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = PermissionMapper.class)
public interface RoleMapper extends EntityMapper<RoleDTO, Role> {
    @Override
    Role toEntity(RoleDTO dto);

    @Override
//    @Mapping(source = "name", target = "name", qualifiedByName = "roleToName")
    RoleDTO toDto(Role entity);

    @Override
    List<Role> toEntity(List<RoleDTO> list);

    @Override
    List<RoleDTO> toDto(List<Role> list);
}
