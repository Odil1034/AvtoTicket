package uz.pdp.avtoticket.service;

import org.springframework.stereotype.Service;

import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.CreateRoleDTO;
import uz.pdp.avtoticket.dto.request.UpdateRoleDTO;
import uz.pdp.avtoticket.dto.response.RoleResponseDTO;
import uz.pdp.avtoticket.entity.Role;
import uz.pdp.avtoticket.enums.RoleType;
import uz.pdp.avtoticket.service.markers.GenericCruidService;

import java.awt.datatransfer.Clipboard;
import java.util.Set;

@Service
public interface RoleService
        extends GenericCruidService<Long, Role, RoleResponseDTO, CreateRoleDTO, UpdateRoleDTO> {

    String getRoleStr(Set<Role> roles);

    // Role nomi bo‘yicha qidirish
    Response<RoleResponseDTO> getRoleByName(String roleName);

    // Role setidan ma’lum permissionni tekshirish
    Response<Boolean> hasPermission(Set<Role> roles, String permission);

    // Foydalanuvchi ma’lum rolega ega ekanligini tekshirish
    Response<Boolean> isUserInRole(Long userId, String roleName);


    // Rolega permission qo‘shish
    void addPermissionToRole(Long roleId, String permission);

    // Role permissionlarini yangilash
    void updateRolePermissions(Long roleId, Set<String> permissions);

    // rolega permission qo‘shish.
    Response<RoleResponseDTO> assignPermissionsToRole(Long roleId, Set<String> permissions);

    // Foydalanuvchining role nomlarini olish
    Response<Set<String>> getRoleNamesByUserId(Long userId);

    Role getRoleEntityByName(String name);
}
