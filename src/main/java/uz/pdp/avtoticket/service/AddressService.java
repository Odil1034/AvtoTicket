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

    // Foydalanuvchining barcha adreslari
    Response<List<AddressResponseDTO>> getAddressesByUserId(Long userId);

    // Busga tegishli manzillar (agar kerak bo‘lsa, masalan, marshrut start/end)
    Response<List<AddressResponseDTO>> getAddressesByBusId(Long busId);

    // Shahar bo‘yicha adreslarni olish
    Response<List<AddressResponseDTO>> getAddressesByCity(String city);

    // Manzil nomi bo‘yicha qidiruv
    Response<List<AddressResponseDTO>> searchAddresses(String query);

    // Default address belgilash (foydalanuvchi uchun)
    Response<Void> setDefaultAddress(Long userId, Long addressId);

    // Default addressni olish
    Response<AddressResponseDTO> getDefaultAddress(Long userId);

    Response<List<AddressResponseDTO>> createAll(@Valid List<CreateAddressDTO> dto);
}

