package uz.pdp.avtoticket.repository.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.avtoticket.entity.address.Region;
import uz.pdp.avtoticket.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 13:05
 */
public interface RegionRepository extends JpaRepository<Region, Long>, Repository {

    @Query("SELECT r FROM Region r WHERE r.id = :id AND r.isDeleted = FALSE")
    Optional<Region> findByIdCustom(Long id);

    @Query("SELECT r FROM Region r WHERE  r.isDeleted = FALSE")
    List<Region> findAllCustom();

    @Modifying
    @Query("UPDATE Region r SET r.isDeleted = TRUE WHERE r.id = :id")
    void deleteByIdCustom(Long id);

    @Query("SELECT r FROM Region r WHERE r.isDeleted = false AND r.soatoId = :soatoId AND r.nameUz = :nameUz")
    Optional<Region> findBySoatoIdAndNameUz(Long soatoId, String nameUz);
}
