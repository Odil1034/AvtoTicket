package uz.pdp.AvtoTicket.entity.seat;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.AvtoTicket.entity.BaseEntity;
import uz.pdp.AvtoTicket.entity.bus.Bus;
import uz.pdp.AvtoTicket.enums.SeatStatus;
import uz.pdp.AvtoTicket.enums.SeatType;

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
    @JoinColumn(name = "bus_id")
    private Bus bus;

}
