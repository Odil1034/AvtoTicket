package uz.pdp.AutoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.AutoTicket.entity.Address;

import java.util.List;
import java.util.Optional;

/**
 * @author Baxriddinov Odiljon
 * @since 02/09/2025 21:47
 */
public interface AddressRepository extends JpaRepository<Address, Long>, Repository {

    @Query("SELECT a FROM Address a WHERE a.id = :id AND a.isDeleted = FALSE")
    Optional<Address> findByIdCustom(Long id);

    @Query("SELECT a FROM Address a WHERE  a.isDeleted = FALSE")
    Optional<List<Address>> findAllCustom();

    @Modifying
    @Query("UPDATE Address a SET a.isDeleted = TRUE WHERE a.id = :id")
    void deleteByIdCustom(Long id);

}
