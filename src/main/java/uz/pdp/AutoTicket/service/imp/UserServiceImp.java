package uz.pdp.AutoTicket.service.imp;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.pdp.AutoTicket.config.SessionUser;
import uz.pdp.AutoTicket.dto.ErrorResponse;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.ChangePasswordDTO;
import uz.pdp.AutoTicket.dto.request.UserCreateDTO;
import uz.pdp.AutoTicket.dto.request.UserUpdateDTO;
import uz.pdp.AutoTicket.dto.response.OrderResponseDTO;
import uz.pdp.AutoTicket.dto.response.user.UserResponseDTO;
import uz.pdp.AutoTicket.entity.User;
import uz.pdp.AutoTicket.exceptions.UserNotFoundException;
import uz.pdp.AutoTicket.mapper.UserMapper;
import uz.pdp.AutoTicket.repository.UserRepository;
import uz.pdp.AutoTicket.service.markers.AbstractService;
import uz.pdp.AutoTicket.service.RoleService;
import uz.pdp.AutoTicket.service.UserService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp extends AbstractService<UserRepository, UserMapper> implements UserService {

    private final RoleService roleService;
    private final SessionUser sessionUser;
    private final PasswordEncoder passwordEncoder;

    @Lazy
    public UserServiceImp(UserRepository repository, UserMapper mapper, RoleService roleService,
                          SessionUser sessionUser, PasswordEncoder passwordEncoder) {
        super(repository, mapper);
        this.roleService = roleService;
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
}
