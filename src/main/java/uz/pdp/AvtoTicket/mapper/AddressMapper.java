package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.*;
import uz.pdp.AvtoTicket.dto.response.AddressDTO;
import uz.pdp.AvtoTicket.entity.address.Address;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper extends EntityMapper<AddressDTO, Address>{
    @Override
    Address toEntity(AddressDTO dto);

    @Override
    AddressDTO toDto(Address entity);

    @Override
    List<Address> toEntity(List<AddressDTO> list);

    @Override
    List<AddressDTO> toDto(List<Address> list);
}
