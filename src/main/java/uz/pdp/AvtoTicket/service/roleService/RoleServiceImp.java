package uz.pdp.AvtoTicket.service.roleService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.AvtoTicket.dto.request.create.CreateRoleDTO;
import uz.pdp.AvtoTicket.dto.response.RoleDTO;
import uz.pdp.AvtoTicket.dto.request.update.UpdateRoleDTO;
import uz.pdp.AvtoTicket.entity.permission.Permission;
import uz.pdp.AvtoTicket.entity.role.Role;
import uz.pdp.AvtoTicket.exceptions.IsDeletedException;
import uz.pdp.AvtoTicket.exceptions.NotFoundException;
import uz.pdp.AvtoTicket.mapper.RoleMapper;
import uz.pdp.AvtoTicket.repository.RoleRepository;
import uz.pdp.AvtoTicket.service.permissionService.PermissionService;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;
    private final PermissionService permissionService;
    private final RoleMapper roleMapper;

    @Override
    public RoleDTO create(CreateRoleDTO dto) {
        Role role = roleMapper.toEntity(dto);
        Set<Permission> permissions = permissionService.findAllByIds(dto.permissionIds());
        role.setPermissions(permissions);
        Role save = roleRepository.save(role);
        return roleMapper.toDTO(save);
    }

    @Override
    public RoleDTO getById(Long id) {
        Role byId = findById(id);
        return roleMapper.toDTO(byId);
    }

    @Override
    public List<RoleDTO> getAll() {
        List<Role> all = roleRepository.findAll();
        return roleMapper.toDTOList(all);
    }

    @Override
    public boolean delete(Long id) {
        Role byId = findById(id);
        byId.setDeleted(true);
        roleRepository.save(byId);
        return true;
    }

    @Override
    public RoleDTO update(Long roleId, UpdateRoleDTO dto) {
        Role byId = findById(roleId);
        roleMapper.toUpdate(byId, dto);
        Role save = roleRepository.save(byId);
        return roleMapper.toDTO(save);
    }

    @Override
    public Role findById(Long roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new NotFoundException("Role not found with id : " + roleId));
        if (!role.isDeleted()) {
            return role;
        } else {
            throw new IsDeletedException("Role is deleted with id = " + roleId);
        }
    }
}

