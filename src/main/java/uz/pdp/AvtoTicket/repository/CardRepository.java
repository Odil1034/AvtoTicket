package uz.pdp.AvtoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.AvtoTicket.entity.card.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
}
