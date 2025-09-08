package uz.pdp.AutoTicket.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.CreateRoleDTO;
import uz.pdp.AutoTicket.dto.response.RoleResponseDTO;
import uz.pdp.AutoTicket.dto.response.user.UserRolesDTO;
import uz.pdp.AutoTicket.service.RoleService;
import uz.pdp.AutoTicket.utils.Constants;

@PreAuthorize("hasRole=\"SUPER_ADMIN\"")
@RestController
@RequestMapping(Constants.BASE_PATH + "role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    // yangi rol yaratish.
    @PostMapping("/create")
    public ResponseEntity<Response<RoleResponseDTO>> createRole(@Valid @RequestBody CreateRoleDTO dto) {
        return ResponseEntity.ok(roleService.create(dto));
    }

    // userga rol biriktirish.
    @PostMapping("/assign-role/{id}")
    Response<UserRolesDTO> assignRoleToUser(@PathVariable("id") Long userId, @NotNull String roleName) {
        return null;
    }
//
//    }
//
//    // rolega permission qo‘shish.
//    Response<RoleResponseDTO> assignPermissionsToRole(Long roleId, Set<String> permissions);
//
//    // Userning role(larini) yangilash
//    Response<UserResponseDTO> updateUserRoles(Long userId, List<String> roles);
//
//    // Foydalanuvchining role nomlarini olish
//    Set<String> getRoleNamesByUserId(Long userId);
//
//    // Rolega permission qo‘shish
//    void addPermissionToRole(Long roleId, String permission);
//
//    // Role permissionlarini yangilash
//    void updateRolePermissions(Long roleId, Set<String> permissions);
//
//    // Barcha userlarni olish
//    Response<List<UserResponseDTO>> getAllUsers();

}
