package uz.pdp.avtoticket.entity.address;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.avtoticket.entity.BaseEntity;
import uz.pdp.avtoticket.enums.CountryNames;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 12:37
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "countries")
public class Country extends BaseEntity {

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private CountryNames name = CountryNames.UZBEKISTAN;

    @OneToMany(mappedBy = "country")
    private List<Region> region;

    public String getName() {
        return name.name();
    }
}
