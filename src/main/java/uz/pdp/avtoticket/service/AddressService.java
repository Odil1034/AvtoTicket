package uz.pdp.avtoticket.service;

import jakarta.validation.Valid;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.address.CreateAddressDTO;
import uz.pdp.avtoticket.dto.request.address.UpdateAddressDTO;
import uz.pdp.avtoticket.dto.response.AddressResponseDTO;
import uz.pdp.avtoticket.entity.Address;
import uz.pdp.avtoticket.service.markers.GenericCruidService;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 12/09/2025 11:52
 */
public interface AddressService extends
        GenericCruidService<Long, Address, AddressResponseDTO, CreateAddressDTO, UpdateAddressDTO> {

    // All addresses of user
    Response<List<AddressResponseDTO>> getAddressesByUserId(Long userId);

    // addresses Busga tegishli manzillar (agar kerak bo‘lsa, masalan, marshrut start/end)
    Response<List<AddressResponseDTO>> getAddressesByBusId(Long busId);

    // Viloyat bo‘yicha adreslarni olish
    Response<List<AddressResponseDTO>> getAddressesByRegion(Long regionId);

    // Tuman bo‘yicha addresslarni olish
    Response<List<AddressResponseDTO>> getAddressesByDistrict(Long districtId);

}

