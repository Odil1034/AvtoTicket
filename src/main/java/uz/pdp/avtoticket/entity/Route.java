package uz.pdp.avtoticket.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.avtoticket.entity.address.District;

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

    @ManyToOne
    @JoinColumn(name = "from_address_id")
    private District fromAddress; // district_id

    @Column(nullable = false)
    private Double lon1;
    @Column(nullable = false)
    private Double lat1;

    @Column(nullable = false)
    private Double lon2;
    @Column(nullable = false)
    private Double lat2;

    @ManyToOne
    @JoinColumn(name = "to_address_id")
    private District toAddress; // district_id

    private Double distance;

    @Column(name = "estimate_time")
    private LocalTime estimateTime;


    @PrePersist
    @PreUpdate
    public void preSave() {
        // Distance
        if (lat1 == null || lon1 == null || lat2 == null || lon2 == null) {
            this.distance = 0.0;
        } else {
            final int R = 6371;
            double dLat = Math.toRadians(lat2 - lat1);
            double dLon = Math.toRadians(lon2 - lon1);
            double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                       Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                       Math.sin(dLon / 2) * Math.sin(dLon / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            this.distance = R * c;
        }

        // Name
        if(fromAddress != null && toAddress != null) {
            this.name = fromAddress.getNameUz() + " - " + toAddress.getNameUz();
        }
    }
}
