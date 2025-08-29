package uz.pdp.AvtoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.AvtoTicket.entity.route.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {

}
