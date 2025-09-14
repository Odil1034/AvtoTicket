package uz.pdp.avtoticket.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_address_id", nullable = false)
    private Address fromAddress;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_address_id", nullable = false)
    private Address toAddress;

    private Double distance;

    @Column(name = "estimate_time")
    private String estimateTime;

}
