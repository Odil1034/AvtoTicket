package uz.pdp.AutoTicket.mapper;

import org.mapstruct.Mapper;

import uz.pdp.AutoTicket.dto.request.CreatePermissionDTO;
import uz.pdp.AutoTicket.dto.request.UpdatePermissionDTO;
import uz.pdp.AutoTicket.dto.response.PermissionResponseDTO;
import uz.pdp.AutoTicket.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper
        extends GenericMapper<Permission, PermissionResponseDTO, CreatePermissionDTO, UpdatePermissionDTO> {

}
