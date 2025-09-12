package uz.pdp.avtoticket.service.imp;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.pdp.avtoticket.config.SessionUser;
import uz.pdp.avtoticket.dto.ErrorResponse;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.ChangePasswordDTO;
import uz.pdp.avtoticket.dto.request.UserCreateDTO;
import uz.pdp.avtoticket.dto.request.UserUpdateDTO;
import uz.pdp.avtoticket.dto.response.OrderResponseDTO;
import uz.pdp.avtoticket.dto.response.user.UserStatusDTO;
import uz.pdp.avtoticket.dto.response.user.UserResponseDTO;
import uz.pdp.avtoticket.dto.response.user.UserRolesDTO;
import uz.pdp.avtoticket.entity.User;
import uz.pdp.avtoticket.enums.RoleType;
import uz.pdp.avtoticket.enums.UserStatus;
import uz.pdp.avtoticket.exceptions.UserNotFoundException;
import uz.pdp.avtoticket.mapper.UserMapper;
import uz.pdp.avtoticket.repository.UserRepository;
import uz.pdp.avtoticket.service.PermissionService;
import uz.pdp.avtoticket.service.markers.AbstractService;
import uz.pdp.avtoticket.service.RoleService;
import uz.pdp.avtoticket.service.UserService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp extends AbstractService<UserRepository, UserMapper> implements UserService {

    private final RoleService roleService;
    private final PermissionService permissionService;
    private final SessionUser sessionUser;
    private final PasswordEncoder passwordEncoder;

    @Lazy
    public UserServiceImp(UserRepository repository, UserMapper mapper, RoleService roleService, PermissionService permissionService,
                          SessionUser sessionUser, PasswordEncoder passwordEncoder) {
        super(repository, mapper);
        this.roleService = roleService;
        this.permissionService = permissionService;
        this.sessionUser = sessionUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found with username {0}", username));
    }

    @Override
    public Response<UserResponseDTO> findMe() {
        return find(sessionUser.getId());
    }

    @Override
    public Response<UserResponseDTO> updateProfile(UserUpdateDTO dto) {
        User user = repository.findByIdCustom(sessionUser.getId())
                .orElseThrow(() -> new UserNotFoundException(
                        "User not found with session id: {0}", sessionUser.getId()));
        mapper.updateEntityFromDto(dto, user);
        User save = repository.save(user);
        return Response.ok(200, mapper.toDto(save), "User updated successfully");
    }

    @Override
    public Response<Boolean> changePassword(ChangePasswordDTO dto) {
        User user = repository.findByIdCustom(sessionUser.getId())
                .orElseThrow(() -> new UserNotFoundException("User not found with session id: {0}", sessionUser.getId()));
        if (passwordEncoder.matches(dto.oldPassword(), user.getPassword())) {
            user.setPassword(passwordEncoder.encode(dto.newPassword()));
            repository.save(user);
            return Response.ok(true);
        }
        return Response.error(HttpStatus.BAD_REQUEST,
                ErrorResponse.of("400", "/user/update", "", getClass().toString(), "Password does not match"));
    }

    @Override
    public Response<List<OrderResponseDTO>> getBookingHistory(Long userId) {
        return null;
    }

    @Override
    public Response<UserResponseDTO> create(UserCreateDTO dto) {
        User user = mapper.fromCreate(dto);
        if (repository.existsUserByUsername(user.getUsername())) {
            Response.error(
                    HttpStatus.CONFLICT,
                    ErrorResponse.of("400", "user/create", "user/register", getClass().toString(), "Username already exists"));
        }
        user.setPassword(passwordEncoder.encode(dto.password()));
        User save = repository.save(user);
        return Response.ok(mapper.toDto(save));
    }

    @Override
    public Response<UserResponseDTO> update(UserUpdateDTO dto) {
        User user = repository.findByIdCustom(sessionUser.getId())
                .orElseThrow(() -> new UserNotFoundException(
                        "User not found with session id: {0}", sessionUser.getId()));
        mapper.updateEntityFromDto(dto, user);
        User save = repository.save(user);
        return Response.ok(200, mapper.toDto(save), "User updated successfully");
    }

    @Override
    public Response<Boolean> delete(Long id) {
        repository.softDelete(id);
        return Response.ok(true);
    }

    @Override
    public Response<UserResponseDTO> find(Long id) {
        return Response.ok(mapper.toDto(repository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not with id {0} found", id))));
    }

    @Override
    public Response<List<UserResponseDTO>> findAll() {
        return Response.ok(repository.findAllCustom().stream()
                .map(mapper::toDto)
                .toList());
    }

    @Override
    public Response<UserStatusDTO> blockUser(Long userId) {
        User user = repository.findByIdCustom(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id {}", userId));
        user.setStatus(UserStatus.BLOCKED);
        User save = repository.save(user);
        return Response.ok(HttpStatus.OK, new UserStatusDTO(save.getId(), save.getStatus()));
    }

    @Override
    public Response<UserStatusDTO> unblockUser(Long userId) {
        User user = repository.findBlockedUser(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id {}", userId));
        user.setStatus(UserStatus.ACTIVE);
        User save = repository.save(user);
        return Response.ok(HttpStatus.OK, new UserStatusDTO(save.getId(), save.getStatus()));
    }

    @Override
    public Response<List<UserResponseDTO>> searchUsersByTripId(Long tripId) {
        return null;
    }

    @Override
    public Response<List<UserResponseDTO>> getUsersByStatus(UserStatus status) {
        return null;
    }

    @Override
    public Response<List<UserResponseDTO>> getTopUsers(int limit) {
        return null;
    }

    @Override
    public Response<UserResponseDTO> updateUserRoles(Long userId, List<String> roles) {
        return null;
    }

    @Override
    public Response<UserRolesDTO> assignRoleToUser(Long userId, RoleType roleName) {
        return null;
    }
}
