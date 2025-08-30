package uz.pdp.AvtoTicket.entity.ticket;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.AvtoTicket.entity.BaseEntity;
import uz.pdp.AvtoTicket.entity.order.Order;
import uz.pdp.AvtoTicket.entity.trip.Trip;
import uz.pdp.AvtoTicket.entity.user.User;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {

    @Column(name = "passenger_name")
    private String passengerName;

    @Column(name = "booking_time")
    private LocalDateTime bookingTime = LocalDateTime.now();

    @Column(nullable = false)
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @Column(name = "seat_number", nullable = false)
    private Integer seatNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

}
