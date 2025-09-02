package uz.pdp.AutoTicket.service.imp;

import org.springframework.context.annotation.Lazy;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.UserCreateDTO;
import uz.pdp.AutoTicket.dto.request.UserUpdateDTO;
import uz.pdp.AutoTicket.dto.response.UserResponseDTO;
import uz.pdp.AutoTicket.entity.User;
import uz.pdp.AutoTicket.mapper.UserMapper;
import uz.pdp.AutoTicket.repository.UserRepository;
import uz.pdp.AutoTicket.service.AbstractService;
import uz.pdp.AutoTicket.service.RoleService;
import uz.pdp.AutoTicket.service.UserService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp extends AbstractService<UserRepository, UserMapper> implements UserService {

    private final RoleService roleService;

    @Lazy
    public UserServiceImp(UserRepository repository, UserMapper mapper, RoleService roleService) {
        super(repository, mapper);
        this.roleService = roleService;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public Response<UserResponseDTO> findMe() {
        return null;
    }

    @Override
    public Response<UserResponseDTO> create(UserCreateDTO dto) {
        return null;
    }

    @Override
    public Response<UserResponseDTO> update(UserUpdateDTO dto) {
        return null;
    }

    @Override
    public Response<Boolean> delete(Long aLong) {
        return null;
    }

    @Override
    public Response<UserResponseDTO> find(Long aLong) {
        return null;
    }

    @Override
    public Response<List<UserResponseDTO>> findAll() {
        return Response.ok(List.of());
    }
}
