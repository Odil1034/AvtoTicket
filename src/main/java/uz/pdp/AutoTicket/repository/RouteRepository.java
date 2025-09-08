package uz.pdp.AutoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.AutoTicket.entity.Route;

/**
 * @author Baxriddinov Odiljon
 * @since 02/09/2025 21:47
 */
public interface RouteRepository extends JpaRepository<Route, Long>, Repository {

}
