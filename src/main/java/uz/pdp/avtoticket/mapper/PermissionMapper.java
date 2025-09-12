package uz.pdp.avtoticket.mapper;

import org.mapstruct.Mapper;

import uz.pdp.avtoticket.dto.request.CreatePermissionDTO;
import uz.pdp.avtoticket.dto.request.UpdatePermissionDTO;
import uz.pdp.avtoticket.dto.response.PermissionResponseDTO;
import uz.pdp.avtoticket.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper
        extends GenericMapper<Permission, PermissionResponseDTO, CreatePermissionDTO, UpdatePermissionDTO> {
}
