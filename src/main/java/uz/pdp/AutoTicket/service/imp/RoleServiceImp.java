package uz.pdp.AutoTicket.service.imp;

import org.springframework.stereotype.Service;

import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.role.CreateRoleDTO;
import uz.pdp.AutoTicket.dto.role.RoleResponseDTO;
import uz.pdp.AutoTicket.dto.role.UpdateRoleDTO;
import uz.pdp.AutoTicket.entity.Permission;
import uz.pdp.AutoTicket.entity.Role;
import uz.pdp.AutoTicket.exceptions.IsDeletedException;
import uz.pdp.AutoTicket.exceptions.NotFoundException;
import uz.pdp.AutoTicket.mapper.RoleMapper;
import uz.pdp.AutoTicket.repository.RoleRepository;
import uz.pdp.AutoTicket.service.AbstractService;
import uz.pdp.AutoTicket.service.PermissionService;
import uz.pdp.AutoTicket.service.RoleService;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImp extends AbstractService<RoleRepository, RoleMapper> implements RoleService {

    private final PermissionService permissionService;

    public RoleServiceImp(RoleRepository repository, RoleMapper mapper, PermissionService permissionService) {
        super(repository, mapper);
        this.permissionService = permissionService;
    }

    @Override
    public Response<RoleResponseDTO> create(CreateRoleDTO dto) {
        return null;
    }

    @Override
    public Response<RoleResponseDTO> update(UpdateRoleDTO dto) {
        return null;
    }

    @Override
    public Response<Boolean> delete(Long aLong) {
        return null;
    }

    @Override
    public Response<RoleResponseDTO> find(Long aLong) {
        return null;
    }

    @Override
    public List<Response<RoleResponseDTO>> findAll() {
        return List.of();
    }
}

