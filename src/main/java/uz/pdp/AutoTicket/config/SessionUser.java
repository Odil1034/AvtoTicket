package uz.pdp.AutoTicket.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SessionUser {

    public Long getCurrentUserId() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();;
    CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
    return userDetails.getId();
    
}
}
