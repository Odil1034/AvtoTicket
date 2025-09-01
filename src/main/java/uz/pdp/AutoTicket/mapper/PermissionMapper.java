package uz.pdp.AutoTicket.mapper;

import org.mapstruct.Mapper;

import uz.pdp.AutoTicket.dto.permission.CreatePermissionDTO;
import uz.pdp.AutoTicket.dto.permission.PermissionResponseDTO;
import uz.pdp.AutoTicket.dto.permission.UpdatePermissionDTO;
import uz.pdp.AutoTicket.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper
        extends GenericMapper<Permission, PermissionResponseDTO, CreatePermissionDTO, UpdatePermissionDTO> {

}
