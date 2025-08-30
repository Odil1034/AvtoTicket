package uz.pdp.AvtoTicket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.AvtoTicket.dto.ApiResponse;
import uz.pdp.AvtoTicket.dto.address.CreateAddressDTO;
import uz.pdp.AvtoTicket.dto.address.AddressResponseDTO;
import uz.pdp.AvtoTicket.dto.address.UpdateAddressDTO;
import uz.pdp.AvtoTicket.service.addressService.AddressService;

@RestController
@RequestMapping("address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse<AddressResponseDTO>> getAddressByID(@PathVariable Long id) {
        AddressResponseDTO byId = addressService.getById(id);
        return ApiResponse.success(byId);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<AddressResponseDTO>> createAddress(@RequestBody CreateAddressDTO dto) {
        AddressResponseDTO createdAddress = addressService.create(dto);
        return ApiResponse.success(createdAddress, "Address is created successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<AddressResponseDTO>> updateAddressById(@PathVariable Long id, @RequestBody UpdateAddressDTO dto) {
        AddressResponseDTO update = addressService.update(id, dto);
        return ApiResponse.success(update, "Address is updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Boolean>> deleteById(@PathVariable Long id) {
        boolean delete = addressService.delete(id);
        return ApiResponse.success(delete, "Address is deleted successfully");
    }
}
