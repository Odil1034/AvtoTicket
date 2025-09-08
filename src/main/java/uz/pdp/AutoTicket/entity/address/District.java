package uz.pdp.AutoTicket.entity.address;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.AutoTicket.entity.BaseEntity;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 12:38
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "disticts")
public class District extends BaseEntity {

    @Column(name = "soato_id", unique = true)
    private Long soatoId;

    @Column(name = "name_uz", nullable = false, unique = true)
    private String nameUz;

    @Column(name = "name_ru", nullable = false, unique = true)
    private String nameRu;

    @Column(name = "name_oz", nullable = false, unique = true)
    private String nameOz;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Village> villages;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;
}
