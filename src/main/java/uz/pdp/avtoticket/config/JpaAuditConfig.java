package uz.pdp.avtoticket.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * @author Baxriddinov Odiljon
 * @since 05/09/2025 10:46
 */

@Configuration
@EnableJpaAuditing
@RequiredArgsConstructor
public class JpaAuditConfig {

    private final SessionUser sessionUser;

    @Bean
    public AuditorAware<Long> auditorAware() {
        return () -> Optional.of(sessionUser.getId());
    }
}

