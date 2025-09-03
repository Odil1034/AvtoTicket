package uz.pdp.AutoTicket.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.AutoTicket.enums.BusModelStatus;
import uz.pdp.AutoTicket.enums.Manufacturer;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "bus_models")
public class BusModel extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private Manufacturer manufacturer;

    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY)
    private List<Bus> buses;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BusModelStatus status = BusModelStatus.ACTIVE;

}
