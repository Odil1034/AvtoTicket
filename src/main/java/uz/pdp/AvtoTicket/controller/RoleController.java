package uz.pdp.AvtoTicket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.AvtoTicket.dto.Response;
import uz.pdp.AvtoTicket.dto.role.CreateRoleDTO;
import uz.pdp.AvtoTicket.dto.role.RoleResponseDTO;
import uz.pdp.AvtoTicket.dto.role.UpdateRoleDTO;
import uz.pdp.AvtoTicket.service.roleService.RoleService;

@RestController
@RequestMapping("role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Response<RoleResponseDTO>> getRoleByID(@PathVariable Long id) {
        RoleResponseDTO byId = roleService.getById(id);
        return Response.success(byId);
    }

    @PostMapping("/create")
    public ResponseEntity<Response<RoleResponseDTO>> createRole(@RequestBody CreateRoleDTO dto) {
        RoleResponseDTO createdRole = roleService.create(dto);
        return Response.success(createdRole, "Role is created successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response<RoleResponseDTO>> updateRoleById(@PathVariable Long id,
                                                                    @RequestBody UpdateRoleDTO dto) {
        RoleResponseDTO update = roleService.update(id, dto);
        return Response.success(update, "Role is updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response<Boolean>> deleteById(@PathVariable Long id) {
        boolean delete = roleService.delete(id);
        return Response.success(delete, "Role is deleted successfully");
    }
}
