package uz.pdp.AvtoTicket.service.userService;

import uz.pdp.AvtoTicket.dto.register.LoginDTO;
import uz.pdp.AvtoTicket.dto.register.SignUpDTO;
import uz.pdp.AvtoTicket.dto.request.create.UserCreateDTO;
import uz.pdp.AvtoTicket.dto.response.UserDTO;
import uz.pdp.AvtoTicket.dto.request.update.UserUpdateDTO;
import uz.pdp.AvtoTicket.entity.user.User;
import uz.pdp.AvtoTicket.service.BaseService;

public interface UserService extends BaseService<User, UserCreateDTO, UserUpdateDTO, UserDTO> {

    UserDTO login(LoginDTO loginDTO);

    UserDTO signUp(SignUpDTO signUpDTO);

}
