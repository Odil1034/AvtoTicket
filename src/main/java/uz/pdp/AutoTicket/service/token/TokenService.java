package uz.pdp.AutoTicket.service.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.auth.TokenRequestDTO;
import uz.pdp.AutoTicket.dto.request.auth.TokenResponseDTO;
import uz.pdp.AutoTicket.entity.User;
import uz.pdp.AutoTicket.exceptions.UserNotFoundException;
import uz.pdp.AutoTicket.repository.UserRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

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

    public Response<TokenResponseDTO> generateToken(TokenRequestDTO dto) {

        String SECRET_KEY = "cHFQw+xqe7OKphBwKR35Cov9BdB3LvBFBafcSTz18xg=";
        SecretKey secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
        String token = Jwts.builder()
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();

        System.out.println(token);
        String username = dto.username();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, dto.password()));

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));
        return null;
    }
}
