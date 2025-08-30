package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uz.pdp.AvtoTicket.dto.response.PermissionDTO;
import uz.pdp.AvtoTicket.dto.request.update.UpdatePermissionDTO;
import uz.pdp.AvtoTicket.entity.permission.Permission;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper extends EntityMapper<PermissionDTO, Permission> {
    @Override
    Permission toEntity(PermissionDTO dto);

    @Override
    PermissionDTO toDto(Permission entity);

    @Override
    List<Permission> toEntity(List<PermissionDTO> list);

    @Override
    List<PermissionDTO> toDto(List<Permission> list);
}
