package uz.pdp.AutoTicket.entity.address;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.AutoTicket.entity.BaseEntity;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 12:41
 */


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "regions")
public class Region extends BaseEntity {

    @Column(name = "soato_id", unique = true)
    private Long soatoId;

    @Column(name = "name_uz", nullable = false, unique = true)
    private String nameUz;

    @Column(name = "name_ru", nullable = false, unique = true)
    private String nameRu;

    @Column(name = "name_oz", nullable = false, unique = true)
    private String nameOz;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "region")
    private List<District> districts;

}
