package uz.pdp.AvtoTicket.service.permissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.AvtoTicket.dto.permission.CreatePermissionDTO;
import uz.pdp.AvtoTicket.dto.permission.PermissionResponseDTO;
import uz.pdp.AvtoTicket.dto.permission.UpdatePermissionDTO;
import uz.pdp.AvtoTicket.entity.permission.Permission;
import uz.pdp.AvtoTicket.exceptions.IsDeletedException;
import uz.pdp.AvtoTicket.exceptions.NotFoundException;
import uz.pdp.AvtoTicket.mapper.PermissionMapper;
import uz.pdp.AvtoTicket.repository.PermissionRepository;
import uz.pdp.AvtoTicket.service.PermissionService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PermissionServiceImp implements PermissionService {

    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    @Override
    public PermissionResponseDTO create(CreatePermissionDTO dto) {
        Permission permission = permissionMapper.toEntity(dto);
        Permission save = permissionRepository.save(permission);
        return permissionMapper.toDTO(save);
    }

    @Override
    public PermissionResponseDTO getById(Long id) {
        Permission byId = findById(id);
        return permissionMapper.toDTO(byId);
    }

    @Override
    public List<PermissionResponseDTO> getAll() {
        List<Permission> all = permissionRepository.findAll();
        return permissionMapper.toDTOList(all);
    }

    @Override
    public boolean delete(Long id) {
        Permission byId = findById(id);
        byId.setDeleted(true);
        permissionRepository.save(byId);
        return true;
    }

    @Override
    public PermissionResponseDTO update(Long permissionId, UpdatePermissionDTO dto) {
        Permission byId = findById(permissionId);
        permissionMapper.toUpdate(byId, dto);
        Permission save = permissionRepository.save(byId);
        return permissionMapper.toDTO(save);
    }

    @Override
    public Permission findById(Long permissionId) {
        Permission permission = permissionRepository.findById(permissionId)
                .orElseThrow(() -> new NotFoundException("Permission not found with id : " + permissionId));
        if (!permission.isDeleted()) {
            return permission;
        } else {
            throw new IsDeletedException("Permission is deleted with id = " + permissionId);
        }
    }

    @Override
    public Set<Permission> findAllByIds(List<Long> permissionIds) {
        Set<Permission> perms = new HashSet<>();
        for (Long permissionId : permissionIds) {
            perms.add(findById(permissionId));
        }
        return perms;
    }
}
