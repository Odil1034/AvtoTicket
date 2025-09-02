package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.request.CreateAddressDTO;
import uz.pdp.AutoTicket.dto.request.UpdateAddressDTO;
import uz.pdp.AutoTicket.dto.response.AddressResponseDTO;
import uz.pdp.AutoTicket.entity.Address;

public interface AddressService
        extends GenericCruidService<Long, Address, AddressResponseDTO, CreateAddressDTO, UpdateAddressDTO> {

}
