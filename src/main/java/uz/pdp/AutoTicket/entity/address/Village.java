package uz.pdp.AutoTicket.entity.address;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.AutoTicket.entity.BaseEntity;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 12:38
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "villages")
public class Village extends BaseEntity {

    @Column(name = "soato_id", unique = true)
    private Long soatoId;

    @Column(name = "name_uz", nullable = false, unique = true)
    private String nameUz;

    @Column(name = "name_ru", nullable = false, unique = true)
    private String nameRu;

    @Column(name = "name_oz", nullable = false, unique = true)
    private String nameOz;

    @JoinColumn(name = "district_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private District district;

}
