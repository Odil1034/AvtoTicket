package uz.pdp.avtoticket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import uz.pdp.avtoticket.entity.address.Country;
import uz.pdp.avtoticket.entity.address.District;
import uz.pdp.avtoticket.entity.address.Region;

/**
 * @author Baxriddinov Odiljon
 * @since 12/09/2025 11:18
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "addresses")
public class Address extends BaseEntity {

    @ManyToOne
    private Country country;

    @ManyToOne
    private Region region;

    @ManyToOne
    private District district;

    private Double latitude;
    private Double longitude;

}
