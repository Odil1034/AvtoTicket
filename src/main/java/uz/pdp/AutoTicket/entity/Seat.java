package uz.pdp.AutoTicket.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.AutoTicket.enums.SeatStatus;
import uz.pdp.AutoTicket.enums.SeatType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "seats")
public class Seat extends BaseEntity {

    @Column(name = "seat_number", updatable = false)
    private Integer seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatType type = SeatType.STANDARD; // BUSINESS, STANDARD

    @Enumerated(EnumType.STRING)
    private SeatStatus status = SeatStatus.EMPTY;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_id", nullable = false)
    private Bus bus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Trip trip;

}
