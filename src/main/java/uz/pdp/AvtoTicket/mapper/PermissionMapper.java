package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uz.pdp.AvtoTicket.dto.permission.CreatePermissionDTO;
import uz.pdp.AvtoTicket.dto.permission.PermissionResponseDTO;
import uz.pdp.AvtoTicket.dto.permission.UpdatePermissionDTO;
import uz.pdp.AvtoTicket.entity.permission.Permission;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    Permission toEntity(CreatePermissionDTO dto);

    Permission toEntity(PermissionResponseDTO dto);

    PermissionResponseDTO toDTO(Permission permission);

    List<Permission> toEntityList(List<PermissionResponseDTO> dto);

    List<PermissionResponseDTO> toDTOList(List<Permission> permissions);

    void toUpdate(@MappingTarget Permission permission, UpdatePermissionDTO dto);
//
//    @Named("permissionToName")
//    default String permissionToName(Permission permission) {
//        return permission == null ? null : permission.getName();
//    }

}
