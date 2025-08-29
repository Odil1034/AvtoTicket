package uz.pdp.AvtoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.AvtoTicket.entity.bus.Bus;

public interface BusRepository extends JpaRepository<Bus, Long> {

}
