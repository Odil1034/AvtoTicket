package uz.pdp.AutoTicket.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.AutoTicket.entity.Role;
import uz.pdp.AutoTicket.entity.Permission;
import uz.pdp.AutoTicket.enums.RoleType;
import uz.pdp.AutoTicket.enums.PermissionType;
import uz.pdp.AutoTicket.repository.RoleRepository;
import uz.pdp.AutoTicket.repository.PermissionRepository;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RbacSeeder implements ApplicationRunner {

    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) {
        syncPermissions();
        syncRoles();
    }

    private void syncPermissions() {
        Arrays.stream(PermissionType.values()).forEach(pt -> permissionRepository.findByAccess(pt.name())
                .orElseGet(() -> permissionRepository.save(
                        Permission.builder()
                                .access(pt.name())
                                .build()
                )));
    }

    private void syncRoles() {
        // DBdagi permissionlarni map qilib olamiz
        Map<String, Permission> permMap = permissionRepository.findAll().stream()
                .collect(Collectors.toMap(Permission::getAccess, Function.identity()));

        // Enumdagi barcha rollarni sync qilamiz
        for (RoleType rt : RoleType.values()) {
            Role role = roleRepository.findByName(rt.name())
                    .orElseGet(() -> roleRepository.save(
                            Role.builder().name(rt.name()).build()
                    ));

            // descriptionni enumdan update qilamiz
            role.setDescription(rt.getDescription());

            // permissionlarni bog‘lab qo‘yamiz
            Set<Permission> mapped = rt.getPermissions().stream()
                    .map(p -> permMap.get(p.name()))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toSet());

            role.setPermissions(mapped);

            roleRepository.save(role);
        }
    }
}
