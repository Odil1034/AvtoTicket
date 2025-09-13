package uz.pdp.avtoticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.avtoticket.entity.RefreshToken;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Baxriddinov Odiljon
 * @since 14/09/2025 02:08
 */
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByToken(String token);

    @Transactional
    @Modifying
    @Query("DELETE FROM RefreshToken t WHERE t.expiredAt < :now")
    void deleteAllExpiredSince(@Param("now") LocalDateTime now);

    @Transactional
    @Modifying
    @Query("DELETE FROM RefreshToken t WHERE t.userId = :userId")
    void deleteByUserId(Long userId);
}
