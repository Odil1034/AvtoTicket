package uz.pdp.avtoticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.avtoticket.entity.Ticket;

import java.util.List;
import java.util.Optional;

/**
 * @author Baxriddinov Odiljon
 * @since 02/09/2025 21:47
 */
public interface TicketRepository extends JpaRepository<Ticket, Long>, Repository {

    @Query("SELECT t FROM Ticket t WHERE t.id = :id AND t.isDeleted = FALSE")
    Optional<Ticket> findByIdCustom(Long id);

    @Query("SELECT t FROM Ticket t WHERE  t.isDeleted = FALSE")
    Optional<List<Ticket>> findAllCustom();

    @Modifying
    @Query("UPDATE Ticket t SET t.isDeleted = TRUE WHERE t.id = :id")
    void deleteByIdCustom(Long id);

}
