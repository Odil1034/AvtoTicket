package uz.pdp.avtoticket.service.imp;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.CreateRoleDTO;
import uz.pdp.avtoticket.dto.request.UpdateRoleDTO;
import uz.pdp.avtoticket.dto.response.RoleResponseDTO;
import uz.pdp.avtoticket.entity.Role;
import uz.pdp.avtoticket.entity.User;
import uz.pdp.avtoticket.exceptions.IsDeletedException;
import uz.pdp.avtoticket.exceptions.ResourceNotFoundException;
import uz.pdp.avtoticket.exceptions.UserNotFoundException;
import uz.pdp.avtoticket.mapper.RoleMapper;
import uz.pdp.avtoticket.repository.RoleRepository;
import uz.pdp.avtoticket.repository.UserRepository;
import uz.pdp.avtoticket.service.UserService;
import uz.pdp.avtoticket.service.markers.AbstractService;
import uz.pdp.avtoticket.service.PermissionService;
import uz.pdp.avtoticket.service.RoleService;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@Service
public class RoleServiceImp extends AbstractService<RoleRepository, RoleMapper> implements RoleService {

    private final PermissionService permissionService;
    private final UserService userService;
    private final UserRepository userRepository;
    private final RoleMapper roleMapper;

    @Lazy
    public RoleServiceImp(RoleRepository repository, RoleMapper mapper, PermissionService permissionService, UserService userService, UserRepository userRepository,
                          RoleMapper roleMapper) {
        super(repository, mapper);
        this.permissionService = permissionService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.roleMapper = roleMapper;
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

    @Override
    public Response<RoleResponseDTO> getRoleByName(String roleName) {
        Role roleEntityByName = getRoleEntityByName(roleName);
        return Response.ok(mapper.toDto(roleEntityByName));
    }

    @Override
    public Response<Boolean> hasPermission(Set<Role> roles, String permission) {
        return null;
    }

    @Override
    public Response<Boolean> isUserInRole(Long userId, String roleName) {
        return null;
    }

    @Override
    public void addPermissionToRole(Long roleId, String permission) {

    }

    @Override
    public void updateRolePermissions(Long roleId, Set<String> permissions) {

    }

    @Override
    public Response<RoleResponseDTO> assignPermissionsToRole(Long roleId, Set<String> permissions) {
        return null;
    }

    @Override
    public Response<Set<String>> getRoleNamesByUserId(Long userId) {
        User user = userRepository.findByIdCustom(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id {}", userId));
        Set<Role> userRoles = user.getRoles();
        Set<String> rolesStr = userRoles.stream().map(Role::getName).collect(Collectors.toSet());
        return Response.ok(rolesStr);
    }

    @Override
    public Role getRoleEntityByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found by name {}", name));
    }
}

