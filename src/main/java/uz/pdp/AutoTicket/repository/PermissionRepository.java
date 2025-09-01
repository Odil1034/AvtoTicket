package uz.pdp.AutoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uz.pdp.AutoTicket.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long>, Repository {

}
