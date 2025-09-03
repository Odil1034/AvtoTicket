package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.request.CreateAddressDTO;
import uz.pdp.AutoTicket.dto.request.UpdateAddressDTO;
import uz.pdp.AutoTicket.dto.response.AddressResponseDTO;
import uz.pdp.AutoTicket.entity.Address;
import uz.pdp.AutoTicket.service.markers.GenericCruidService;

public interface AddressService extends
        GenericCruidService<Long, Address, AddressResponseDTO, CreateAddressDTO, UpdateAddressDTO> {

}
