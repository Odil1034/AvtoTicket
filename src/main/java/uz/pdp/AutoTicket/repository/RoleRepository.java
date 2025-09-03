package uz.pdp.AutoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.AutoTicket.entity.Permission;
import uz.pdp.AutoTicket.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long>, Repository {

    @Query(value = "SELECT r FROM Role r WHERE r.id = :roleId AND r.isDeleted = false")
    Optional<Role> findByIdCustom(Long roleId);

    @Modifying
    @Query(value = "UPDATE Role r SET r.isDeleted = TRUE WHERE r.id = :id")
    void softDelete(Long id);

    @Query(value = "SELECT r FROM Role r WHERE r.isDeleted = FALSE")
    List<Role> findAllCustom();

    @Query(value = "SELECT r FROM Role r WHERE r.name = :name AND r.isDeleted = FALSE")
    Optional<Role> findByName(String name);

}
