package uz.pdp.AvtoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.AvtoTicket.entity.ticket.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
