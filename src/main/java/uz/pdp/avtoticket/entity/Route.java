package uz.pdp.avtoticket.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "routes")
@Builder
public class Route extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "from_address_id")
    private Address fromAddress;

    @ManyToOne
    @JoinColumn(name = "to_address_id")
    private Address toAddress;

    private Double distance;

    @Column(name = "estimate_time")
    private LocalTime estimateTime;

}
