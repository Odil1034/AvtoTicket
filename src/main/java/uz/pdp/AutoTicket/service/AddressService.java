package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.CreateAddressDTO;
import uz.pdp.AutoTicket.dto.request.UpdateAddressDTO;
import uz.pdp.AutoTicket.dto.response.AddressResponseDTO;
import uz.pdp.AutoTicket.entity.Address;
import uz.pdp.AutoTicket.service.markers.GenericCruidService;

import java.util.List;

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
}
