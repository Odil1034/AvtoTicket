package uz.pdp.AutoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import uz.pdp.AutoTicket.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, Repository {

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.isDeleted = false AND u.status = 'ACTIVE'")
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.isDeleted = false AND u.status = 'ACTIVE'")
    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.id = :userId AND u.isDeleted = false AND u.status = 'ACTIVE'")
    Optional<User> findByIdCustom(Long userId);
}
