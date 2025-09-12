package uz.pdp.avtoticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.avtoticket.entity.Ticket;
import uz.pdp.avtoticket.entity.Trip;

import java.util.List;
import java.util.Optional;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 10:38
 */
public interface TripRepository extends JpaRepository<Trip, Long>, Repository {

    @Query("SELECT t FROM Trip t WHERE t.id = :id AND t.isDeleted = FALSE")
    Optional<Trip > findByIdCustom(Long id);

    @Query("SELECT t FROM Trip t WHERE  t.isDeleted = FALSE")
    Optional<List<Trip >> findAllCustom();

    @Modifying
    @Query("UPDATE Trip t SET t.isDeleted = TRUE WHERE t.id = :id")
    void deleteByIdCustom(Long id);

}
