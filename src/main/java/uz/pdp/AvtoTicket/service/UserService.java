package uz.pdp.AvtoTicket.service.userService;

import jakarta.validation.constraints.NotNull;
import uz.pdp.AvtoTicket.dto.Response;
import uz.pdp.AvtoTicket.dto.auth.LoginDTO;
import uz.pdp.AvtoTicket.dto.auth.SignUpDTO;
import uz.pdp.AvtoTicket.dto.user.UserCreateDTO;
import uz.pdp.AvtoTicket.dto.user.UserResponseDTO;
import uz.pdp.AvtoTicket.dto.user.UserUpdateDTO;
import uz.pdp.AvtoTicket.entity.user.User;
import uz.pdp.AvtoTicket.service.GenericCruidService;
import uz.pdp.AvtoTicket.service.GenericService;

public interface UserService
        extends GenericCruidService<Long, User, UserResponseDTO, UserCreateDTO, UserUpdateDTO> {

    User findByUsername(@NotNull String username);

    Response<UserResponseDTO> findMe();
}
