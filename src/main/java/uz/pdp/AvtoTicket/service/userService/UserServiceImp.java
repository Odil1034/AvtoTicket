package uz.pdp.AvtoTicket.service.userService;

import org.springframework.stereotype.Service;
import uz.pdp.AvtoTicket.dto.register.LoginDTO;
import uz.pdp.AvtoTicket.dto.register.SignUpDTO;
import uz.pdp.AvtoTicket.dto.user.UserCreateDTO;
import uz.pdp.AvtoTicket.dto.user.UserResponseDTO;
import uz.pdp.AvtoTicket.dto.user.UserUpdateDTO;
import uz.pdp.AvtoTicket.entity.user.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {


    @Override
    public UserResponseDTO login(LoginDTO loginDTO) {
        return null;
    }

    @Override
    public boolean signUp(SignUpDTO signUpDTO) {
        return false;
    }

    @Override
    public UserResponseDTO create(UserCreateDTO dto) {
        return null;
    }

    @Override
    public UserResponseDTO getById(Long id) {
        return null;
    }

    @Override
    public List<UserResponseDTO> getAll() {
        return List.of();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public UserResponseDTO update(Long userId, UserUpdateDTO dto) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }
}
