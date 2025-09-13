package uz.pdp.avtoticket.service.token;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import uz.pdp.avtoticket.dto.request.auth.TokenDTO;
import uz.pdp.avtoticket.entity.RefreshToken;
import uz.pdp.avtoticket.entity.User;
import uz.pdp.avtoticket.exceptions.UserNotFoundException;
import uz.pdp.avtoticket.repository.RefreshTokenRepository;
import uz.pdp.avtoticket.repository.UserRepository;
import uz.pdp.avtoticket.utils.JwtTokenUtils;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Baxriddinov Odiljon
 * @since 14/09/2025 02:22
 */

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    @Lazy
    private final JwtTokenUtils jwtTokenUtils;
    private final UserRepository userRepository;

    public void save(TokenDTO refreshTokenDTO) {
        String username = jwtTokenUtils.extractUsername(refreshTokenDTO.token());

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not by username {0}", username));

        // 1️⃣ avvalgi tokenlarni o'chirish
        refreshTokenRepository.deleteByUserId(user.getId());

        // 2️⃣ yangi token yaratish va saqlash
        RefreshToken newRefreshToken = RefreshToken.builder()
                .userId(user.getId())
                .token(refreshTokenDTO.token())
                .expiredAt(refreshTokenDTO.expiredAt())
                .issuedAt(refreshTokenDTO.issuedAt())
                .expiredIn(refreshTokenDTO.expiresIn())
                .build();

        refreshTokenRepository.save(newRefreshToken);
    }


    @Scheduled(cron = "0 0 * * * *") // har soatda ishga tushadi
    public void removeExpiredTokens() {
        refreshTokenRepository.deleteAllExpiredSince(LocalDateTime.now());
    }

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

}
