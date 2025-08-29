package uz.pdp.AvtoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.AvtoTicket.entity.trip.Trip;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
