package uz.pdp.AvtoTicket.service.addressService;

import uz.pdp.AvtoTicket.dto.response.AddressDTO;
import uz.pdp.AvtoTicket.dto.request.create.CreateAddressDTO;
import uz.pdp.AvtoTicket.dto.request.update.UpdateAddressDTO;
import uz.pdp.AvtoTicket.entity.address.Address;
import uz.pdp.AvtoTicket.service.BaseService;

public interface AddressService extends BaseService<Address, CreateAddressDTO,
        UpdateAddressDTO, AddressDTO> {
}
