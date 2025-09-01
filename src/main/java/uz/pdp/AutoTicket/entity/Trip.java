package uz.pdp.AutoTicket.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.AutoTicket.enums.TripStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "trips")
public class Trip extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    private Route route;

    private LocalDateTime departure;

    private LocalDateTime arrival;

    @Column(name = "count_of_seats", nullable = false)
    private Integer countOfSeats;

    @Builder.Default
    @Column(name = "trip_status")
    private TripStatus isActive = TripStatus.DELAYED;

    private Double price;

}
