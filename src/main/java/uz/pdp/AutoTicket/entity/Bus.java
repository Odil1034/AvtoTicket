package uz.pdp.AutoTicket.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.AutoTicket.enums.BusStatus;
import uz.pdp.AutoTicket.enums.FuelType;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "buses")
public class Bus extends BaseEntity {

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "bus_model_id", nullable = false)
    private BusModel model;

    @Column(name = "count_of_seats", nullable = false)
    private Integer countOfSeats;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type")
    private FuelType fuelType = FuelType.UNKNOWN;

    @Column(name = "standing_capacity")
    private Integer standingCapacity;

    @OneToMany(mappedBy = "bus", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Document> documents;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private User owner;

    private String description;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private BusStatus status = BusStatus.AVAILABILITY;

    @Column(name = "plate_number", unique = true, nullable = false)
    private String plateNumber;  //  10 A321AA UZ

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Seat> totalSeats;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Trip> trips;

}
