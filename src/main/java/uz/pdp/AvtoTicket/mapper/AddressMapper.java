package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.*;
import uz.pdp.AvtoTicket.dto.address.CreateAddressDTO;
import uz.pdp.AvtoTicket.entity.address.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toEntity(CreateAddressDTO dto);

}
