package uz.pdp.AutoTicket.service;

import jakarta.validation.constraints.NotNull;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.ChangePasswordDTO;
import uz.pdp.AutoTicket.dto.request.UserCreateDTO;
import uz.pdp.AutoTicket.dto.request.UserUpdateDTO;
import uz.pdp.AutoTicket.dto.response.OrderResponseDTO;
import uz.pdp.AutoTicket.dto.response.user.UserResponseDTO;
import uz.pdp.AutoTicket.entity.User;
import uz.pdp.AutoTicket.service.markers.GenericCruidService;

import java.util.List;

public interface UserService
        extends GenericCruidService<Long, User, UserResponseDTO, UserCreateDTO, UserUpdateDTO> {

    User findByUsername(@NotNull String username);

    Response<UserResponseDTO> findMe();

    // user profilini yangilaydi.
    Response<UserResponseDTO> updateProfile(UserUpdateDTO dto);

    // user passwordini almashtiradi
    Response<Boolean> changePassword(ChangePasswordDTO dto);

    // userning chipta tarixini ko‘rish.
    Response<List<OrderResponseDTO>> getBookingHistory(Long userId);
}
