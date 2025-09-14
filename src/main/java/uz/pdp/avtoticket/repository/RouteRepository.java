package uz.pdp.avtoticket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.avtoticket.entity.Route;

import java.util.List;
import java.util.Optional;

/**
 * @author Baxriddinov Odiljon
 * @since 02/09/2025 21:47
 */
public interface RouteRepository extends JpaRepository<Route, Long>, Repository {

    @Query("SELECT r FROM Route r WHERE r.id = :id AND r.isDeleted = FALSE")
    Optional<Route> findByIdCustom(Long id);

    @Query("SELECT r FROM Route r WHERE  r.isDeleted = FALSE")
    List<Route> findAllCustom();

    @Modifying
    @Query("UPDATE Route r SET r.isDeleted = TRUE WHERE r.id = :id")
    void deleteByIdCustom(Long id);

    Page<Route> findByName(String name, Pageable pageable);

}
