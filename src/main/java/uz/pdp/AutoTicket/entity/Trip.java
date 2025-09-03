package uz.pdp.AutoTicket.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.AutoTicket.enums.TripStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "trips")
public class Trip extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    private LocalDateTime departure;  // Ketish

    private LocalDateTime arrival;      // Kelish

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "seats")
    private List<Seat> seats;

    @Column(name = "count_of_seats", nullable = false)
    private Integer countOfSeats;    // umumiy o‘rindiqlar soni

    @Column(name = "empty_seats")
    private Integer emptySeats;   // bo‘sh o‘rindiqlar soni

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "trip_status")
    private TripStatus tripStatus = TripStatus.STARTED;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false)
    private Bus bus;

}
