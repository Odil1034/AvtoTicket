package uz.pdp.avtoticket.service;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.ChangePasswordDTO;
import uz.pdp.avtoticket.dto.request.UpdateEmailDTO;
import uz.pdp.avtoticket.dto.request.UserCreateDTO;
import uz.pdp.avtoticket.dto.request.UserUpdateDTO;
import uz.pdp.avtoticket.dto.response.OrderResponseDTO;
import uz.pdp.avtoticket.dto.response.user.UserStatusDTO;
import uz.pdp.avtoticket.dto.response.user.UserResponseDTO;
import uz.pdp.avtoticket.dto.response.user.UserRolesDTO;
import uz.pdp.avtoticket.entity.User;
import uz.pdp.avtoticket.enums.RoleType;
import uz.pdp.avtoticket.enums.UserStatus;
import uz.pdp.avtoticket.service.markers.GenericCruidService;

import java.util.List;

public interface UserService
        extends GenericCruidService<Long, User, UserResponseDTO, UserCreateDTO, UserUpdateDTO> {

    User findByUsername(@NotNull @NotBlank String username);

    Response<UserResponseDTO> findMe();

    // user passwordini almashtiradi
    Response<Boolean> changePassword(ChangePasswordDTO dto);

    // userning chipta tarixini ko‘rish.
    Response<List<OrderResponseDTO>> getBookingHistory(@NotNull Long userId);

    Response<UserStatusDTO> blockUser(@NotNull Long userId);

    Response<UserStatusDTO> unblockUser(@NotNull Long userId);

    // Foydalanuvchilarni qidirish (username, email, phone bo‘yicha)
//    Response<List<UserResponseDTO>> searchUsersByTripId(@NotNull Long tripId);

    // Foydalanuvchilarni status bo‘yicha filterlash (ACTIVE, BLOCKED, DELETED, va h.k.)
    Response<List<UserStatusDTO>> getUsersByStatus(UserStatus status);

    // Statistikalar: eng ko‘p buyurtma qilgan userlar
    Response<List<UserResponseDTO>> getTopUsers(int limit);

    // Userning role(larini) yangilash
    Response<UserRolesDTO> updateUserRoles(@NotNull Long userId, List<String> roles);

    // userga rol biriktirish.
    Response<UserRolesDTO> assignRoleToUser(@NotNull Long userId, RoleType roleName);

    Response<UserResponseDTO> changeEmail(UpdateEmailDTO dto);
    Response<UserResponseDTO> changePhoneNumber(@NotNull String phoneNumber);
    Response<UserResponseDTO> changePassport(@NotNull String passportNumber);

}
