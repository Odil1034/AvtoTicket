package uz.pdp.AutoTicket.entity.address;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import uz.pdp.AutoTicket.entity.BaseEntity;

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

    private String name;

    @OneToMany(mappedBy = "country")
    private List<Region> region;
}
