package uz.pdp.avtoticket.repository.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.avtoticket.entity.address.District;
import uz.pdp.avtoticket.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 13:05
 */
public interface DistrictRepository extends JpaRepository<District, Long>, Repository {

    @Query("SELECT d FROM District d WHERE d.id = :id AND d.isDeleted = FALSE")
    Optional<District> findByIdCustom(Long id);

    @Query("SELECT d FROM District d WHERE  d.isDeleted = FALSE")
    List<District> findAllCustom();

    @Modifying
    @Query("UPDATE District d SET d.isDeleted = TRUE WHERE d.id = :id")
    void deleteByIdCustom(Long id);

    @Query("SELECT d FROM District d WHERE d.isDeleted = false AND d.region.id = :regionId")
    List<District> findByRegion(Long regionId);
}
