package uz.pdp.AutoTicket.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import uz.pdp.AutoTicket.utils.Constants;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author Baxriddinov Odiljon
 * @since 01/09/2025 07:56
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

        filterChain.doFilter(request, response);
    }
}
