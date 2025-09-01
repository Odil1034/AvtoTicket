package uz.pdp.AutoTicket.service.imp;

import org.springframework.stereotype.Service;

import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.role.CreateRoleDTO;
import uz.pdp.AutoTicket.dto.role.RoleResponseDTO;
import uz.pdp.AutoTicket.dto.role.UpdateRoleDTO;
import uz.pdp.AutoTicket.mapper.RoleMapper;
import uz.pdp.AutoTicket.repository.RoleRepository;
import uz.pdp.AutoTicket.service.AbstractService;
import uz.pdp.AutoTicket.service.PermissionService;
import uz.pdp.AutoTicket.service.RoleService;

import java.util.List;

@Service
public class RoleServiceImp extends AbstractService<RoleRepository, RoleMapper> implements RoleService {

    private final PermissionService permissionService;
    private final RoleRepository roleRepository;

    public RoleServiceImp(RoleRepository repository, RoleMapper mapper, PermissionService permissionService, RoleRepository roleRepository) {
        super(repository, mapper);
        this.permissionService = permissionService;
        this.roleRepository = roleRepository;
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
    public Response<List<RoleResponseDTO>> findAll() {
        return Response.ok(repository.findAllCustom().stream()
                .map(mapper::toDto)
                .toList());
    }
}

