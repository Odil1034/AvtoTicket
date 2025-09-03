package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.CreatePermissionDTO;
import uz.pdp.AutoTicket.dto.request.UpdatePermissionDTO;
import uz.pdp.AutoTicket.dto.response.PermissionResponseDTO;
import uz.pdp.AutoTicket.entity.Permission;
import uz.pdp.AutoTicket.service.markers.GenericCruidService;

import java.util.List;

public interface PermissionService extends GenericCruidService
        <Long, Permission, PermissionResponseDTO, CreatePermissionDTO, UpdatePermissionDTO> {
    // userda shu huquq bormi tekshiradi.
    Response<Boolean> hasPermission(Long userId, String permission);

    // userning barcha huquqlarini qaytaradi.
    Response<List<PermissionResponseDTO>> getUserPermissions(Long userId);
}
