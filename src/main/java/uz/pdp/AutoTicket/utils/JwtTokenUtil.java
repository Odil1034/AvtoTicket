package uz.pdp.AutoTicket.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Baxriddinov Odiljon
 * @since 31/08/2025 16:54
 */

@Component
public class JwtTokenUtil {

    @Value("${token.secret-key}")
    private String SECRET_KEY;

    @Value("${token.expiration.access}")
    private long ACCESS_TOKEN_EXPIRATION;

    @Value("${token.expiration.refresh}")
    private long REFRESH_TOKEN_EXPIRATION;



}
