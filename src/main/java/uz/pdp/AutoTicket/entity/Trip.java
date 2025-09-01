package uz.pdp.AutoTicket.entity;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "is_actice")
    private boolean isActive = true;

    private Double price;

}
