package uz.pdp.AvtoTicket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.AvtoTicket.dto.ApiResponse;
import uz.pdp.AvtoTicket.dto.request.create.CreatePermissionDTO;
import uz.pdp.AvtoTicket.dto.response.PermissionDTO;
import uz.pdp.AvtoTicket.dto.request.update.UpdatePermissionDTO;
import uz.pdp.AvtoTicket.service.permissionService.PermissionService;

@RestController
@RequestMapping("permission")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse<PermissionDTO>> getPermissionByID(@PathVariable Long id) {
        PermissionDTO byId = permissionService.getById(id);
        return ApiResponse.success(byId);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<PermissionDTO>> createPermission(@RequestBody CreatePermissionDTO dto) {
        PermissionDTO createdPermission = permissionService.create(dto);
        return ApiResponse.success(createdPermission, "Permission is created successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<PermissionDTO>> updatePermissionById(@PathVariable Long id,
                                                                           @RequestBody UpdatePermissionDTO dto) {
        PermissionDTO update = permissionService.update(id, dto);
        return ApiResponse.success(update, "Permission is updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Boolean>> deleteById(@PathVariable Long id) {
        boolean delete = permissionService.delete(id);
        return ApiResponse.success(delete, "Permission is deleted successfully");
    }
}
