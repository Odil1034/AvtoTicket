package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.response.user.BlockUserDTO;
import uz.pdp.AutoTicket.dto.response.user.UserResponseDTO;
import uz.pdp.AutoTicket.service.markers.GenericService;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 16:29
 */
public interface AdminManagementService extends GenericService {

    // userni bloklash.
    Response<BlockUserDTO> blockUser(Long userId);
    Response<BlockUserDTO> unblockUser(Long userId);

    // Barcha userlarni olish
    Response<List<UserResponseDTO>> getAllUsers();

    // Userni ID bo‘yicha olish
    Response<UserResponseDTO> getUserById(Long userId);

    // Userni o‘chirish (soft delete qilsa yaxshi)
    Response<Boolean> deleteUser(Long userId);

    // Foydalanuvchilarni qidirish (username, email, phone bo‘yicha)
    Response<List<UserResponseDTO>> searchUsers(String query);

    // Foydalanuvchilarni status bo‘yicha filterlash (ACTIVE, BLOCKED, DELETED, va h.k.)
    Response<List<UserResponseDTO>> getUsersByStatus(String status);

    // Statistikalar: eng ko‘p buyurtma qilgan userlar
    Response<List<UserResponseDTO>> getTopUsers(int limit);

}
