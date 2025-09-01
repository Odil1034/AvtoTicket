package uz.pdp.AutoTicket.service.imp;

import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.user.UserCreateDTO;
import uz.pdp.AutoTicket.dto.user.UserResponseDTO;
import uz.pdp.AutoTicket.dto.user.UserUpdateDTO;
import uz.pdp.AutoTicket.entity.User;
import uz.pdp.AutoTicket.mapper.UserMapper;
import uz.pdp.AutoTicket.repository.UserRepository;
import uz.pdp.AutoTicket.service.AbstractService;
import uz.pdp.AutoTicket.service.UserService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp extends AbstractService<UserRepository, UserMapper> implements UserService {
    public UserServiceImp(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
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
        return null;
    }

}
