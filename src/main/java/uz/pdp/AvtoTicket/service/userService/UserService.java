package uz.pdp.AvtoTicket.service.userService;

import uz.pdp.AvtoTicket.dto.register.LoginDTO;
import uz.pdp.AvtoTicket.dto.register.SignUpDTO;
import uz.pdp.AvtoTicket.dto.user.UserCreateDTO;
import uz.pdp.AvtoTicket.dto.user.UserResponseDTO;
import uz.pdp.AvtoTicket.dto.user.UserUpdateDTO;
import uz.pdp.AvtoTicket.entity.user.User;
import uz.pdp.AvtoTicket.service.BaseService;

public interface UserService extends BaseService<User, UserCreateDTO, UserUpdateDTO, UserResponseDTO> {

    UserResponseDTO login(LoginDTO loginDTO);

    UserResponseDTO signUp(SignUpDTO signUpDTO);

}
