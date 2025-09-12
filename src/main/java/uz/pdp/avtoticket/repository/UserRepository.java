package uz.pdp.avtoticket.repository;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.avtoticket.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, Repository {

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.isDeleted = false AND u.status = 'ACTIVE'")
    Optional<User> findByEmail(@NotNull String email);

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.isDeleted = false AND u.status = 'ACTIVE'")
    Optional<User> findByUsername(@NotNull String username);

    @Query("SELECT u FROM User u WHERE u.id = :userId AND u.isDeleted = false AND u.status = 'ACTIVE'")
    Optional<User> findByIdCustom(@NotNull Long userId);

    @Modifying
    @Query("UPDATE User u SET u.isDeleted = TRUE WHERE u.id = :id")
    void softDelete(Long id);

    @Query("SELECT u FROM User u WHERE u.isDeleted = FALSE AND u.status = 'ACTIVE'")
    List<User> findAllCustom();

    boolean existsUserByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.id= :userId AND u.isDeleted = FALSE AND u.status = 'BLOCKED'")
    Optional<User> findBlockedUser(Long id);
}
