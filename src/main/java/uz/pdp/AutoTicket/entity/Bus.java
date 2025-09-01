package uz.pdp.AutoTicket.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.AutoTicket.enums.FuelType;
import uz.pdp.AutoTicket.enums.ModelType;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "buses")
public class Bus extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "model_name", nullable = false)
    private ModelType modelName;

    private String manufacturer;

    @Column(name = "count_of_seats", nullable = false)
    private Integer countOfSeats;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type")
    private FuelType fuelType = FuelType.UNKNOWN;

    @Column(name = "standing_capacity")
    private Integer standingCapacity;

    @OneToMany
    private List<Document> documents;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private User owner;

    private String description;

    @Column(name = "plate_number", unique = true, nullable = false)
    private String plateNumber;  //  10 A321AA UZ

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Seat> seats;

}
