package uz.pdp.avtoticket.repository.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.avtoticket.entity.Address;
import uz.pdp.avtoticket.entity.address.Country;
import uz.pdp.avtoticket.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 13:04
 */
public interface AddressRepository extends JpaRepository<Address, Long>, Repository {

    @Query("SELECT a FROM Address a WHERE a.id = :id AND a.isDeleted = FALSE")
    Optional<Address> findByIdCustom(Long id);

    @Query("SELECT a FROM Address a WHERE  a.isDeleted = FALSE")
    List<Address> findAllCustom();

    @Modifying
    @Query("UPDATE Address a SET a.isDeleted = TRUE WHERE a.id = :id")
    void deleteByIdCustom(Long id);

    @Query("SELECT a FROM Address a WHERE a.district.id = :districtId AND a.isDeleted = false")
    List<Address> findByDistrictId(Long districtId);
}
