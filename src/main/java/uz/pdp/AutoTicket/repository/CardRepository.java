package uz.pdp.AutoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.AutoTicket.entity.Address;
import uz.pdp.AutoTicket.entity.Card;

import java.util.List;
import java.util.Optional;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 10:38
 */
public interface CardRepository extends JpaRepository<Card, Long>, Repository {

    @Query("SELECT c FROM Card c WHERE c.id = :id AND c.isDeleted = FALSE")
    Optional<Card > findByIdCustom(Long id);

    @Query("SELECT c FROM Card c WHERE  c.isDeleted = FALSE")
    Optional<List<Card >> findAllCustom();

    @Modifying
    @Query("UPDATE Card c SET c.isDeleted = TRUE WHERE c.id = :id")
    void deleteByIdCustom(Long id);

}
