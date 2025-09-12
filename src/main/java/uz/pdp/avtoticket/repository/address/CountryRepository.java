package uz.pdp.avtoticket.repository.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.avtoticket.entity.address.Country;
import uz.pdp.avtoticket.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 13:04
 */
public interface CountryRepository extends JpaRepository<Country, Long>, Repository {

    @Query("SELECT c FROM Country c WHERE c.id = :id AND c.isDeleted = FALSE")
    Optional<Country> findByIdCustom(Long id);

    @Query("SELECT c FROM Country c WHERE  c.isDeleted = FALSE")
    List<Country> findAllCustom();

    @Modifying
    @Query("UPDATE Country c SET c.isDeleted = TRUE WHERE c.id = :id")
    void deleteByIdCustom(Long id);
}
