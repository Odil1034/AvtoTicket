package uz.pdp.AutoTicket.service;

import java.util.List;
import java.util.Set;

import uz.pdp.AutoTicket.dto.permission.CreatePermissionDTO;
import uz.pdp.AutoTicket.dto.permission.PermissionResponseDTO;
import uz.pdp.AutoTicket.dto.permission.UpdatePermissionDTO;
import uz.pdp.AutoTicket.entity.Permission;

public interface PermissionService extends GenericCruidService
        <Long, Permission, PermissionResponseDTO, CreatePermissionDTO, UpdatePermissionDTO>{

    Set<Permission> findAllByIds(List<Long> longs);
}
