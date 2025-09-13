package uz.pdp.avtoticket.controller.address;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.address.CreateAddressDTO;
import uz.pdp.avtoticket.dto.response.AddressResponseDTO;
import uz.pdp.avtoticket.dto.request.address.UpdateAddressDTO;
import uz.pdp.avtoticket.service.AddressService;
import uz.pdp.avtoticket.utils.Constants;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 12/09/2025 11:15
 */

@RestController
@RequestMapping(Constants.BASE_PATH + "/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<Response<AddressResponseDTO>> create(@Valid @RequestBody CreateAddressDTO dto) {
        return ResponseEntity.ok(addressService.create(dto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response<AddressResponseDTO>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.find(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Response<AddressResponseDTO>> update(@Valid @RequestBody UpdateAddressDTO dto) {
        return ResponseEntity.ok(addressService.update(dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response<Boolean>> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.delete(id));
    }

    @GetMapping("/all")
    public ResponseEntity<Response<List<AddressResponseDTO>>> getAll() {
        return ResponseEntity.ok(addressService.findAll());
    }
}

