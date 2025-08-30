package uz.pdp.AvtoTicket.service.permissionService;

import uz.pdp.AvtoTicket.dto.permission.CreatePermissionDTO;
import uz.pdp.AvtoTicket.dto.permission.PermissionResponseDTO;
import uz.pdp.AvtoTicket.dto.permission.UpdatePermissionDTO;
import uz.pdp.AvtoTicket.entity.permission.Permission;
import uz.pdp.AvtoTicket.service.BaseService;

import java.util.List;
import java.util.Set;

public interface PermissionService extends BaseService<Permission,
        CreatePermissionDTO, UpdatePermissionDTO, PermissionResponseDTO> {

    Set<Permission> findAllByIds(List<Long> permissionIds);
}
