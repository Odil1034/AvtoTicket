package uz.pdp.AutoTicket.service;

import java.util.List;
import java.util.Set;

import uz.pdp.AutoTicket.dto.request.CreatePermissionDTO;
import uz.pdp.AutoTicket.dto.request.UpdatePermissionDTO;
import uz.pdp.AutoTicket.dto.response.PermissionResponseDTO;
import uz.pdp.AutoTicket.entity.Permission;

public interface PermissionService extends GenericCruidService
        <Long, Permission, PermissionResponseDTO, CreatePermissionDTO, UpdatePermissionDTO>{

    Set<Permission> findAllByIds(List<Long> longs);
}
