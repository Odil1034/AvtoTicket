package uz.pdp.avtoticket.controller;

import lombok.RequiredArgsConstructor;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.CreatePermissionDTO;
import uz.pdp.avtoticket.dto.request.UpdatePermissionDTO;
import uz.pdp.avtoticket.dto.response.PermissionResponseDTO;
import uz.pdp.avtoticket.service.PermissionService;

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
