package uz.pdp.AutoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uz.pdp.AutoTicket.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, Repository {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);
}
