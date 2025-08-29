//package uz.pdp.AvtoTicket.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import uz.pdp.AvtoTicket.entity.permission.Permission;
//import uz.pdp.AvtoTicket.entity.role.Role;
//import uz.pdp.AvtoTicket.entity.user.User;
//import uz.pdp.AvtoTicket.exceptions.NotFoundException;
//import uz.pdp.AvtoTicket.repository.UserRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//@RequiredArgsConstructor
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new NotFoundException("User not found"));
//
//        return new CustomUserDetails(
//                user.getId(),
//                user.getUsername(),
//                user.getPassword(),
//                user.getEmail(),
//                user.getPhoneNumber(),
//                user.getStatus(),
//                mapRoleAndPermissions(user.getRoles()),
//                user.isDeleted()
//        );
//    }
//
//    private Set<? extends GrantedAuthority> mapRoleAndPermissions(Set<Role> roles) {
//        Set<GrantedAuthority> authorities = new HashSet<>();
//
//        for (Role role : roles) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
//
//            for (Permission permission : role.getPermissions()) {
//                authorities.add(new SimpleGrantedAuthority(permission.getName()));
//            }
//        }
//
//        return authorities;
//    }
//}
