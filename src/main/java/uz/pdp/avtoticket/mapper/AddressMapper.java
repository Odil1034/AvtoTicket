package uz.pdp.avtoticket.mapper;

import org.mapstruct.Mapper;
import uz.pdp.avtoticket.dto.request.address.UpdateAddressDTO;
import uz.pdp.avtoticket.dto.request.address.CreateAddressDTO;
import uz.pdp.avtoticket.dto.response.AddressResponseDTO;
import uz.pdp.avtoticket.entity.Address;

/**
 * @author Baxriddinov Odiljon
 * @since 12/09/2025 11:49
 */
@Mapper(componentModel = "spring")
public interface AddressMapper extends GenericMapper<Address, AddressResponseDTO, CreateAddressDTO, UpdateAddressDTO> {
}
