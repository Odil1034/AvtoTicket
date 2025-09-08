package uz.pdp.AutoTicket.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.response.user.BlockUserDTO;
import uz.pdp.AutoTicket.dto.response.user.UserResponseDTO;
import uz.pdp.AutoTicket.exceptions.UserNotFoundException;
import uz.pdp.AutoTicket.repository.UserRepository;
import uz.pdp.AutoTicket.service.AdminManagementService;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 16:29
 */
@Service
@RequiredArgsConstructor
public class AdminManagementServiceImp implements AdminManagementService {

    private final UserRepository userRepository;

    @Override
    public Response<BlockUserDTO> blockUser(Long userId) {
        userRepository.findByIdCustom(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id {0}", userId));
        return null;
    }

    @Override
    public Response<BlockUserDTO> unblockUser(Long userId) {
        return null;
    }

    @Override
    public Response<List<UserResponseDTO>> getAllUsers() {
        return null;
    }

    @Override
    public Response<UserResponseDTO> getUserById(Long userId) {
        return null;
    }

    @Override
    public Response<Boolean> deleteUser(Long userId) {
        return null;
    }

    @Override
    public Response<List<UserResponseDTO>> searchUsers(String query) {
        return null;
    }

    @Override
    public Response<List<UserResponseDTO>> getUsersByStatus(String status) {
        return null;
    }

    @Override
    public Response<List<UserResponseDTO>> getTopUsers(int limit) {
        return null;
    }
}
