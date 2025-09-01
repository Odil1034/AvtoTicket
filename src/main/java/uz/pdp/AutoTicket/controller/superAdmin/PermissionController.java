package uz.pdp.AutoTicket.controller.superAdmin;

import lombok.RequiredArgsConstructor;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.permission.CreatePermissionDTO;
import uz.pdp.AutoTicket.dto.permission.PermissionResponseDTO;
import uz.pdp.AutoTicket.dto.permission.UpdatePermissionDTO;
import uz.pdp.AutoTicket.service.PermissionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("permission")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Response<PermissionResponseDTO>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(permissionService.find(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Response<PermissionResponseDTO>> createPermission(@RequestBody CreatePermissionDTO dto) {
        return ResponseEntity.ok(permissionService.create(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response<PermissionResponseDTO>> updateById(@RequestBody UpdatePermissionDTO dto) {
        return ResponseEntity.ok(permissionService.update(dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response<Boolean>> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok( permissionService.delete(id));
    }
}
