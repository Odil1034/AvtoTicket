package uz.pdp.avtoticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.avtoticket.entity.Document;

import java.util.List;
import java.util.Optional;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 10:40
 */
public interface DocumentRepository extends JpaRepository<Document, Long>, Repository {

    @Query("SELECT d FROM Document d WHERE d.id = :id AND d.isDeleted = FALSE")
    Optional<Document > findByIdCustom(Long id);

    @Query("SELECT d FROM Document d WHERE  d.isDeleted = FALSE")
    Optional<List<Document >> findAllCustom();

    @Modifying
    @Query("UPDATE Document d SET d.isDeleted = TRUE WHERE d.id = :id")
    void deleteByIdCustom(Long id);

}
