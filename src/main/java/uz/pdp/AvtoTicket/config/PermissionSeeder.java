package uz.pdp.AvtoTicket.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.pdp.AvtoTicket.entity.permission.Permission;
import uz.pdp.AvtoTicket.enums.permission.Action;
import uz.pdp.AvtoTicket.enums.permission.EntityType;
import uz.pdp.AvtoTicket.repository.PermissionRepository;
@Component
@RequiredArgsConstructor
public class PermissionSeeder implements CommandLineRunner {

    private final PermissionRepository permissionRepository;

    @Override
    public void run(String... args) {
        if (permissionRepository.count() == 0) {

            // 🔹 CRUD + LIST larni avtomatik qo‘shish
            for (EntityType entity : EntityType.values()) {
                for (Action action : Action.values()) {
                    // Faqat CRUD + LIST actionlarni qo‘shamiz
                    if (action.isCrudOrList()) {
                        Permission build = Permission.builder()
                                .name(action.name()+"_"+entity.name())
                                .action(action)
                                .entity(entity)
                                .description(action + " permission for " + entity)
                                .build();
                        permissionRepository.save(build);
                    }
                }
            }

            // 🔹 Maxsus permissionlarni qo‘lda qo‘shish
            permissionRepository.save(Permission.builder()
                    .name(Action.APPROVE.name()+"_"+EntityType.ORDER.name())
                    .action(Action.APPROVE)   // enum ichida bor
                    .entity(EntityType.ORDER) // ORDER_APPROVE
                    .description("Approve order")
                    .build());

            permissionRepository.save(Permission.builder()
                    .name(Action.RESET_PASSWORD.name()+"_"+EntityType.USER.name())
                    .action(Action.RESET_PASSWORD) // enum ichida bor
                    .entity(EntityType.USER)       // USER_RESET_PASSWORD
                    .description("Reset user password")
                    .build());
        }
    }
}



