package uz.pdp.avtoticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.avtoticket.entity.Seat;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 10:40
 */
public interface SeatRepository extends JpaRepository<Seat, Long>, Repository {
}
