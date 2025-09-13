package uz.pdp.avtoticket.service.token;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.auth.TokenDTO;
import uz.pdp.avtoticket.dto.request.auth.TokenResponseDTO;
import uz.pdp.avtoticket.entity.RefreshToken;
import uz.pdp.avtoticket.entity.User;
import uz.pdp.avtoticket.exceptions.TokenExpiredException;
import uz.pdp.avtoticket.exceptions.UserNotFoundException;
import uz.pdp.avtoticket.repository.UserRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import uz.pdp.avtoticket.utils.JwtTokenUtils;

import java.time.LocalDateTime;

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
    private final RefreshTokenService refreshTokenService;

    public Response<TokenResponseDTO> generateToken(@NotNull String username, @NotNull String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        var user = userRepository.findByUsername(username).orElseThrow(
                () -> new UserNotFoundException("User not found with username: {0}", username)
        );
        var accessToken = jwtTokenUtils.generateAccessToken(user.getId(), user.getUsername(), user.getRoles());
        TokenDTO refreshToken = jwtTokenUtils.generateRefreshToken(user.getUsername());
        refreshTokenService.save(refreshToken);

        return Response.ok(TokenResponseDTO.of(user.getId(), accessToken, refreshToken));
    }

    public Response<TokenResponseDTO> refreshToken(@NotNull String refreshToken) {
        if (!jwtTokenUtils.validateToken(refreshToken)) {
            throw new TokenExpiredException("Token has expired or invalid: {0}", refreshToken);
        }

        RefreshToken savedToken = refreshTokenService.findByToken(refreshToken)
                .orElseThrow(() -> new TokenExpiredException("Refresh token not found in DB"));

        if (savedToken.getExpiredAt().isBefore(LocalDateTime.now())) {
            throw new TokenExpiredException("Refresh token expired: {0}", refreshToken);
        }

        String username = jwtTokenUtils.extractUsername(refreshToken);
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UserNotFoundException("User not found with username: {0}", username));
        var newAccessToken = jwtTokenUtils.generateAccessToken(user.getId(), user.getUsername(), user.getRoles());
        var newRefreshToken = jwtTokenUtils.generateRefreshToken(user.getUsername());

        return Response.ok(TokenResponseDTO.of(user.getId(), newAccessToken, newRefreshToken));
    }
}
