package uz.pdp.AutoTicket.service.token;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.auth.RefreshTokenRequestDTO;
import uz.pdp.AutoTicket.dto.auth.TokenRequestDTO;
import uz.pdp.AutoTicket.dto.auth.TokenResponseDTO;
import uz.pdp.AutoTicket.entity.User;
import uz.pdp.AutoTicket.exceptions.UserNotFoundException;
import uz.pdp.AutoTicket.repository.UserRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

/**
 * @author Baxriddinov Odiljon
 * @since 31/08/2025 21:32
 */

@Service
@RequiredArgsConstructor
public class TokenService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public Response<TokenResponseDTO> generateToken(TokenRequestDTO dto) {

        String username = dto.username();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, dto.password()));

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));

        return Response.ok(null);
    }

    public Response<TokenResponseDTO> refreshToken(RefreshTokenRequestDTO dto) {
        return null;
    }
}
