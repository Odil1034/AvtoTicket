package uz.pdp.AvtoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.AvtoTicket.entity.role.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
