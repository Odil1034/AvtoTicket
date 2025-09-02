package uz.pdp.AutoTicket.service.imp;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.CreateRoleDTO;
import uz.pdp.AutoTicket.dto.request.UpdateRoleDTO;
import uz.pdp.AutoTicket.dto.response.RoleResponseDTO;
import uz.pdp.AutoTicket.entity.Role;
import uz.pdp.AutoTicket.exceptions.IsDeletedException;
import uz.pdp.AutoTicket.mapper.RoleMapper;
import uz.pdp.AutoTicket.repository.RoleRepository;
import uz.pdp.AutoTicket.service.AbstractService;
import uz.pdp.AutoTicket.service.PermissionService;
import uz.pdp.AutoTicket.service.RoleService;

import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

@Service
public class RoleServiceImp extends AbstractService<RoleRepository, RoleMapper> implements RoleService {

    private final PermissionService permissionService;

    @Lazy
    public RoleServiceImp(RoleRepository repository, RoleMapper mapper, PermissionService permissionService) {
        super(repository, mapper);
        this.permissionService = permissionService;
    }

    @Override
    public Response<RoleResponseDTO> create(CreateRoleDTO dto) {
        Role role = mapper.fromCreate(dto);
        Role save = repository.save(role);
        RoleResponseDTO roleResDTO = mapper.toDto(save);
        return Response.ok(HttpStatus.CREATED, roleResDTO);
    }

    @Override
    public Response<RoleResponseDTO> update(UpdateRoleDTO dto) {
        final Role entity = mapper.fromUpdate(dto);
        final Role newEntity = repository.save(entity);
        return Response.ok(mapper.toDto(newEntity));
    }

    @Override
    public Response<Boolean> delete(Long id) {
        repository.softDelete(id);
        return Response.ok(true);
    }

    @Override
    public Response<RoleResponseDTO> find(Long roleId) {
        Role role = repository.findByIdCustom(roleId)
                .orElseThrow(() -> new IsDeletedException("Role is deleted with id {0}", roleId));
        return Response.ok(mapper.toDto(role));
    }

    @Override
    public Response<List<RoleResponseDTO>> findAll() {
        List<Role> roles = repository.findAllCustom();
        return Response.ok(roles.stream().map(mapper::toDto).toList());
    }

    @Override
    public String getRoleStr(Set<Role> roles) {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        for (Role role : roles) {
            joiner.add(role.getName());
        }
        return joiner.toString();
    }
}

