package uz.pdp.AutoTicket.service;

import jakarta.validation.constraints.NotNull;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.UserCreateDTO;
import uz.pdp.AutoTicket.dto.request.UserUpdateDTO;
import uz.pdp.AutoTicket.dto.response.UserResponseDTO;
import uz.pdp.AutoTicket.entity.User;
import uz.pdp.AutoTicket.service.markers.GenericCruidService;

public interface UserService
        extends GenericCruidService<Long, User, UserResponseDTO, UserCreateDTO, UserUpdateDTO> {

    User findByUsername(@NotNull String username);

    Response<UserResponseDTO> findMe();
}
