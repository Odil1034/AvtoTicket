package uz.pdp.AutoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import uz.pdp.AutoTicket.entity.Role;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long>, Repository {

    @Query("SELECT r FROM Role r WHERE r.isDeleted = FALSE")
    List<Role> findAllCustom();
}
