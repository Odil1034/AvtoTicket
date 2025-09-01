package uz.pdp.AutoTicket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "addresses")
public class Address extends BaseEntity {

    private String region;
    private String city;
    private String district;

    private Double longitude;   // optional
    private Double latitude;    // optional

}
