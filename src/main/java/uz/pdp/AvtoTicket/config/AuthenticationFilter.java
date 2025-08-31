package uz.pdp.AvtoTicket.config;

import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.pdp.AvtoTicket.utils.Constants;

import java.io.IOException;

/**
 * @author Baxriddinov Odiljon
 * @since 31/08/2025 16:45
 */

@Component
public class AuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader(Constants.AUTH_HEADER);
        if (authorization == null || !authorization.startsWith(Constants.AUTH_TYPE)) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = authorization.substring(Constants.AUTH_TYPE.length());
        


    }
}
