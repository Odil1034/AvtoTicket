//package uz.pdp.AvtoTicket.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import uz.pdp.AvtoTicket.repository.UserRepository;
//
//@Configuration
//public class SecurityConfig {
//
//    String[] WHITE_LIST = {
//            "/auth/login",
//            "/auth/signup",
//            "/user/**",
//            "/swagger-ui.html",
//            "/swagger-ui/**",
//            "/api-docs"
//    };
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http,
//                                                   CustomUserDetailsService customUserDetailsService, UserRepository userRepository)
//            throws Exception {
//        http.authorizeHttpRequests(
//                auth -> {
//                    auth.requestMatchers("/**").authenticated();
//                    auth.requestMatchers(WHITE_LIST).permitAll();
//                }
//        );
//
//
//        http.userDetailsService(customUserDetailsService);
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}
