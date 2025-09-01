package uz.pdp.AutoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uz.pdp.AutoTicket.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>, Repository {

}
