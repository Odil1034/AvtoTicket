package uz.pdp.AvtoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.AvtoTicket.entity.address.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
