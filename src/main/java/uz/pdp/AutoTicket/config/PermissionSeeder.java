package uz.pdp.AutoTicket.config;

import lombok.RequiredArgsConstructor;
import uz.pdp.AutoTicket.entity.Role;
import uz.pdp.AutoTicket.enums.RoleTypes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.pdp.AutoTicket.repository.RoleRepository;

@Component
@RequiredArgsConstructor
public class PermissionSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        for (RoleTypes value : RoleTypes.values()) {
            roleRepository.save(Role.builder().name(value.name()).build());
        }
    }
}



