package uz.pdp.AutoTicket.mapper;

import org.mapstruct.Mapper;
import uz.pdp.AutoTicket.dto.request.CreateAddressDTO;
import uz.pdp.AutoTicket.dto.request.UpdateAddressDTO;
import uz.pdp.AutoTicket.dto.response.AddressResponseDTO;

/**
 * @author Baxriddinov Odiljon
 * @since 05/09/2025 23:06
 */
@Mapper(componentModel = "spring")
public interface AddressMapper
        extends GenericMapper<Address, AddressResponseDTO, CreateAddressDTO, UpdateAddressDTO> {

}
