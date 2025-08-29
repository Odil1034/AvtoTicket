package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uz.pdp.AvtoTicket.dto.role.CreateRoleDTO;
import uz.pdp.AvtoTicket.dto.role.RoleResponseDTO;
import uz.pdp.AvtoTicket.dto.role.UpdateRoleDTO;
import uz.pdp.AvtoTicket.entity.role.Role;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toEntity(CreateRoleDTO dto);

    Role toEntity(RoleResponseDTO dto);

    RoleResponseDTO toDTO(Role role);

    List<Role> toEntityList(List<RoleResponseDTO> dto);

    List<RoleResponseDTO> toDTOList(List<Role> roles);

    void toUpdate(@MappingTarget Role role, UpdateRoleDTO dto);

}
