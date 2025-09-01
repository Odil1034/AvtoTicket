package uz.pdp.AutoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import uz.pdp.AutoTicket.entity.Permission;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission, Long>, Repository {

    @Query("SELECT p FROM Permission p WHERE p.access = :name AND p.isDeleted = false")
    Optional<Permission> findByAccess(String name);
}
