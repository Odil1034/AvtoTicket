package uz.pdp.AutoTicket.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import uz.pdp.AutoTicket.dto.request.auth.TokenDTO;
import uz.pdp.AutoTicket.entity.Role;
import uz.pdp.AutoTicket.service.RoleService;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.function.Function;

/**
 * @author Baxriddinov Odiljon
 * @since 31/08/2025 16:54
 */


@Component
public class JwtTokenUtil {

    private final RoleService roleService;

    @Value("${token.secret.key}")
    private String SECRET_KEY;

    @Value("${token.expiration.access}")
    private long ACCESS_TOKEN_EXPIRATION;

    @Value("${token.expiration.refresh}")
    private long REFRESH_TOKEN_EXPIRATION;

    public JwtTokenUtil(RoleService roleService) {
        this.roleService = roleService;
    }

    public TokenDTO generateAccessToken(Long id, String username, Set<Role> roles) {
        Map<String, Object> map = new HashMap<>();
        String rolesStr = roleService.getRoleStr(roles);
        System.out.println(roles);
        map.put("id", id);
        map.put("roles", rolesStr);

        LocalDateTime issuedAt = LocalDateTime.now();
        LocalDateTime expiredAt = issuedAt.minusSeconds(ACCESS_TOKEN_EXPIRATION / 1000);
        String token = Jwts.builder()
                .subject(username)
                .claims(map)
                .issuedAt(Date.from(issuedAt.atZone(ZoneId.systemDefault()).toInstant()))
                .expiration(Date.from(expiredAt.atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(getSignKey())
                .compact();
        System.out.println(token);

        return new TokenDTO(token, issuedAt, expiredAt, ACCESS_TOKEN_EXPIRATION / 1000);
    }

    public TokenDTO generateRefreshToken(@NonNull String username) {
        LocalDateTime issuedAt = LocalDateTime.now();
        LocalDateTime expiredAt = issuedAt.minusSeconds(REFRESH_TOKEN_EXPIRATION / 1000);
        String token = Jwts.builder()
                .subject(username)
                .issuedAt(Date.from(issuedAt.atZone(ZoneId.systemDefault()).toInstant()))
                .expiration(Date.from(expiredAt.atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(getSignKey())
                .compact();
        System.out.println(token);

        return new TokenDTO(token, issuedAt, expiredAt, REFRESH_TOKEN_EXPIRATION / 1000);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSignKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
    }

    private Long extractId(String token) {
        return extractAllClaims(token).get("id", Long.class);
    }

    private boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return userDetails.getUsername().equals(username) && !isTokenExpired(token);
    }

    public boolean validateToken(String token) {
        return !isTokenExpired(token);
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private boolean isTokenExpired(String token) {
        try {
            final Date expiration = extractClaim(token, Claims::getExpiration);
            return expiration != null && expiration.before(new Date());
        } catch (Exception e) {
            return true;
        }

    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private String extractUsername(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getSubject();  // Subject is username
    }

}
