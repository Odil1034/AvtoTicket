package uz.pdp.AvtoTicket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.AvtoTicket.dto.ApiResponse;
import uz.pdp.AvtoTicket.dto.request.create.CreateRoleDTO;
import uz.pdp.AvtoTicket.dto.response.RoleDTO;
import uz.pdp.AvtoTicket.dto.request.update.UpdateRoleDTO;
import uz.pdp.AvtoTicket.service.roleService.RoleService;

@RestController
@RequestMapping("role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse<RoleDTO>> getRoleByID(@PathVariable Long id) {
        RoleDTO byId = roleService.getById(id);
        return ApiResponse.success(byId);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<RoleDTO>> createRole(@RequestBody CreateRoleDTO dto) {
        RoleDTO createdRole = roleService.create(dto);
        return ApiResponse.success(createdRole, "Role is created successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<RoleDTO>> updateRoleById(@PathVariable Long id,
                                                               @RequestBody UpdateRoleDTO dto) {
        RoleDTO update = roleService.update(id, dto);
        return ApiResponse.success(update, "Role is updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Boolean>> deleteById(@PathVariable Long id) {
        boolean delete = roleService.delete(id);
        return ApiResponse.success(delete, "Role is deleted successfully");
    }
}
