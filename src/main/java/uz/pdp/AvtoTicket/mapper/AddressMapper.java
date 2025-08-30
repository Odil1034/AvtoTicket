package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uz.pdp.AvtoTicket.dto.address.AddressResponseDTO;
import uz.pdp.AvtoTicket.dto.address.CreateAddressDTO;
import uz.pdp.AvtoTicket.dto.address.UpdateAddressDTO;
import uz.pdp.AvtoTicket.entity.address.Address;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toEntity(CreateAddressDTO dto);

    Address toEntity(AddressResponseDTO dto);

    AddressResponseDTO toDTO(Address address);

    List<AddressResponseDTO> toDTOList(List<Address> address);

    void toUpdate(@MappingTarget Address address, UpdateAddressDTO dto);
}
