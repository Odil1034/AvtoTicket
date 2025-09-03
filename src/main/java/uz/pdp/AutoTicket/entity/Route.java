package uz.pdp.AutoTicket.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "routes")
public class Route extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @OneToOne
    @JoinColumn(name = "from_address_id")
    private Address fromAddress;

    @OneToOne
    @JoinColumn(name = "to_address_id")
    private Address toAddress;

    private Double distance;

    @Column(name = "estimate_time")
    private LocalTime estimateTime;
}
