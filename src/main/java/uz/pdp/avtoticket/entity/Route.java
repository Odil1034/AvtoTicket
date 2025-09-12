package uz.pdp.avtoticket.entity;

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


    @PrePersist
    @PreUpdate
    public void preSave() {
        if (fromAddress == null || toAddress == null) {
            this.distance = 0.0;
            this.name = null;
            return;
        }

        Double lat1 = fromAddress.getLatitude();
        Double lon1 = fromAddress.getLongitude();
        Double lat2 = toAddress.getLatitude();
        Double lon2 = toAddress.getLongitude();

        // Distance
        if (lat1 == null || lon1 == null || lat2 == null || lon2 == null) {
            this.distance = 0.0;
        } else {
            final int R = 6371; // Earth radius km
            double dLat = Math.toRadians(lat2 - lat1);
            double dLon = Math.toRadians(lon2 - lon1);
            double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                       Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                       Math.sin(dLon / 2) * Math.sin(dLon / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            this.distance = Math.round(R * c * 100.0) / 100.0; // 2 decimal places
        }

        // Name
        String fromName = (fromAddress.getDistrict() != null) ? fromAddress.getDistrict().getNameUz() : "Unknown";
        String toName   = (toAddress.getDistrict() != null)   ? toAddress.getDistrict().getNameUz()   : "Unknown";
        this.name = fromName + " - " + toName;
    }

}
