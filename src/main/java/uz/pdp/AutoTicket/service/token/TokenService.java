package uz.pdp.AutoTicket.service.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import uz.pdp.AutoTicket.config.SessionUser;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.auth.TokenRequestDTO;
import uz.pdp.AutoTicket.dto.request.auth.TokenResponseDTO;
import uz.pdp.AutoTicket.dto.response.user.UserResponseDTO;
import uz.pdp.AutoTicket.entity.User;
import uz.pdp.AutoTicket.exceptions.TokenExpiredException;
import uz.pdp.AutoTicket.exceptions.UserNotFoundException;
import uz.pdp.AutoTicket.repository.UserRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import uz.pdp.AutoTicket.utils.JwtTokenUtils;

import javax.crypto.SecretKey;

/**
 * @author Baxriddinov Odiljon
 * @since 31/08/2025 21:32
 */

@Service
@RequiredArgsConstructor
public class TokenService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtTokenUtils jwtTokenUtils;
    private final SessionUser sessionUser;

    public Response<TokenResponseDTO> generateToken(@NotNull String username, @NotNull String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        var user = userRepository.findByUsername(username).orElseThrow(
                () -> new UserNotFoundException("User not found with username: {0}", username)
        );
        var accessToken = jwtTokenUtils.generateAccessToken(user.getId(), user.getUsername(), user.getRoles());
        var refreshToken = jwtTokenUtils.generateRefreshToken(user.getUsername());

        return Response.ok(TokenResponseDTO.of(user.getId(), accessToken, refreshToken));
    }

    public Response<TokenResponseDTO> refreshToken(@NotNull String refreshToken) {
        if (!jwtTokenUtils.validateToken(refreshToken)) {
            throw new TokenExpiredException("Token has expired or invalid: {0}", refreshToken);
        }
        String username = jwtTokenUtils.extractUsername(refreshToken);
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UserNotFoundException("User not found with username: {0}", username));
        var newAccessToken = jwtTokenUtils.generateAccessToken(user.getId(), user.getUsername(), user.getRoles());
        var newRefreshToken = jwtTokenUtils.generateRefreshToken(user.getUsername());

        return Response.ok(TokenResponseDTO.of(user.getId(), newAccessToken, newRefreshToken));
    }
}
