package uz.pdp.AvtoTicket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.AvtoTicket.dto.Response;
import uz.pdp.AvtoTicket.dto.permission.CreatePermissionDTO;
import uz.pdp.AvtoTicket.dto.permission.PermissionResponseDTO;
import uz.pdp.AvtoTicket.dto.permission.UpdatePermissionDTO;
import uz.pdp.AvtoTicket.service.permissionService.PermissionService;

@RestController
@RequestMapping("permission")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Response<PermissionResponseDTO>> getPermissionByID(@PathVariable Long id) {
        PermissionResponseDTO byId = permissionService.getById(id);
        return Response.success(byId);
    }

    @PostMapping("/create")
    public ResponseEntity<Response<PermissionResponseDTO>> createPermission(@RequestBody CreatePermissionDTO dto) {
        PermissionResponseDTO createdPermission = permissionService.create(dto);
        return Response.success(createdPermission, "Permission is created successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response<PermissionResponseDTO>> updatePermissionById(@PathVariable Long id,
                                                                                @RequestBody UpdatePermissionDTO dto) {
        PermissionResponseDTO update = permissionService.update(id, dto);
        return Response.success(update, "Permission is updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response<Boolean>> deleteById(@PathVariable Long id) {
        boolean delete = permissionService.delete(id);
        return Response.success(delete, "Permission is deleted successfully");
    }
}
