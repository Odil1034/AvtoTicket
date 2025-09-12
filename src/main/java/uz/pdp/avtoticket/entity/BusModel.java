package uz.pdp.avtoticket.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.avtoticket.enums.BusModelStatus;
import uz.pdp.avtoticket.enums.Manufacturer;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "bus_models")
public class BusModel extends BaseEntity {

    @Column(name = "name", unique = true, nullable = false)
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
