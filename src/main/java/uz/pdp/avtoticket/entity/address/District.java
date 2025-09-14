package uz.pdp.avtoticket.entity.address;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.avtoticket.entity.Auditable;
import uz.pdp.avtoticket.entity.BaseEntity;
import uz.pdp.avtoticket.entity.BaseEntityNoAudit;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 12:38
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "districts")
public class District extends BaseEntityNoAudit {

    @Column(name = "soato_id", unique = true)
    private Long soatoId;

    @Column(name = "name_uz", nullable = false, unique = true)
    private String nameUz;

    @Column(name = "name_ru", nullable = false, unique = true)
    private String nameRu;

    @Column(name = "name_oz", nullable = false, unique = true)
    private String nameOz;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

}
