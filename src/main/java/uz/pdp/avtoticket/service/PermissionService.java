package uz.pdp.avtoticket.service;

import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.CreatePermissionDTO;
import uz.pdp.avtoticket.dto.request.UpdatePermissionDTO;
import uz.pdp.avtoticket.dto.response.PermissionResponseDTO;
import uz.pdp.avtoticket.entity.Permission;
import uz.pdp.avtoticket.service.markers.GenericCruidService;

import java.util.List;

public interface PermissionService extends GenericCruidService
        <Long, Permission, PermissionResponseDTO, CreatePermissionDTO, UpdatePermissionDTO> {
    // userda shu huquq bormi tekshiradi.
    Response<Boolean> hasPermission(Long userId, String permission);

    // userning barcha huquqlarini qaytaradi.
    Response<List<PermissionResponseDTO>> getUserPermissions(Long userId);
}
