package uz.pdp.AvtoTicket.service.permissionService;

import uz.pdp.AvtoTicket.dto.request.create.CreatePermissionDTO;
import uz.pdp.AvtoTicket.dto.response.PermissionDTO;
import uz.pdp.AvtoTicket.dto.request.update.UpdatePermissionDTO;
import uz.pdp.AvtoTicket.entity.permission.Permission;
import uz.pdp.AvtoTicket.service.BaseService;

import java.util.List;
import java.util.Set;

public interface PermissionService extends BaseService<Permission,
        CreatePermissionDTO, UpdatePermissionDTO, PermissionDTO> {

    Set<Permission> findAllByIds(List<Long> permissionIds);
}
