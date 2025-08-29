package uz.pdp.AvtoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.AvtoTicket.entity.permission.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
