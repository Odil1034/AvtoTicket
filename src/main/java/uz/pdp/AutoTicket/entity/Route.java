package uz.pdp.AutoTicket.entity;

import jakarta.persistence.*;
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
