package uz.pdp.AvtoTicket.service.addressService;

import uz.pdp.AvtoTicket.dto.address.AddressResponseDTO;
import uz.pdp.AvtoTicket.dto.address.CreateAddressDTO;
import uz.pdp.AvtoTicket.dto.address.UpdateAddressDTO;
import uz.pdp.AvtoTicket.entity.address.Address;
import uz.pdp.AvtoTicket.service.BaseService;

public interface AddressService extends BaseService<Address, CreateAddressDTO,
        UpdateAddressDTO, AddressResponseDTO> {
}
