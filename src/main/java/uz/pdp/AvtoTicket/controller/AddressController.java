package uz.pdp.AvtoTicket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.AvtoTicket.dto.ApiResponse;
import uz.pdp.AvtoTicket.dto.request.create.CreateAddressDTO;
import uz.pdp.AvtoTicket.dto.response.AddressDTO;
import uz.pdp.AvtoTicket.dto.request.update.UpdateAddressDTO;
import uz.pdp.AvtoTicket.service.addressService.AddressService;

@RestController
@RequestMapping("address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse<AddressDTO>> getAddressByID(@PathVariable Long id) {
        AddressDTO byId = addressService.getById(id);
        return ApiResponse.success(byId);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<AddressDTO>> createAddress(@RequestBody CreateAddressDTO dto) {
        AddressDTO createdAddress = addressService.create(dto);
        return ApiResponse.success(createdAddress, "Address is created successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<AddressDTO>> updateAddressById(@PathVariable Long id, @RequestBody UpdateAddressDTO dto) {
        AddressDTO update = addressService.update(id, dto);
        return ApiResponse.success(update, "Address is updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Boolean>> deleteById(@PathVariable Long id) {
        boolean delete = addressService.delete(id);
        return ApiResponse.success(delete, "Address is deleted successfully");
    }
}
