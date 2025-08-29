package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import uz.pdp.AvtoTicket.dto.role.CreateRoleDTO;
import uz.pdp.AvtoTicket.dto.role.RoleResponseDTO;
import uz.pdp.AvtoTicket.dto.role.UpdateRoleDTO;
import uz.pdp.AvtoTicket.entity.role.Role;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = PermissionMapper.class)
public interface RoleMapper {

    Role toEntity(CreateRoleDTO dto);

    Role toEntity(RoleResponseDTO dto);

    RoleResponseDTO toDTO(Role role);

    List<Role> toEntityList(List<RoleResponseDTO> dto);

    List<RoleResponseDTO> toDTOList(List<Role> roles);

    void toUpdate(@MappingTarget Role role, UpdateRoleDTO dto);
/*
    @Named("roleToName")
    default String roleToName(Role role) {
        return role == null ? null : role.getName();
    }

    @Named("rolesToRoleNames")
    default List<String> roleToName(Set<Role> roles) {
        List<String> list = roles.stream()
                .map(Role::getName)
                .toList();
        return list;
    }*/
}
