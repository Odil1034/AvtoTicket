package uz.pdp.AutoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.AutoTicket.entity.Permission;

import java.util.List;
import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission, Long>, Repository {

    @Query("SELECT p FROM Permission p WHERE p.access = :name AND p.isDeleted = false")
    Optional<Permission> findByAccess(String name);

    @Query("SELECT p FROM Permission p WHERE p.id = :id AND p.isDeleted = FALSE")
    Optional<Permission> findByIdCustom(Long id);

    @Query("SELECT p FROM Permission p WHERE  p.isDeleted = FALSE")
    Optional<List<Permission>> findAllCustom();

    @Modifying
    @Query("UPDATE Permission p SET p.isDeleted = TRUE WHERE p.id = :id")
    void deleteByIdCustom(Long id);

}
