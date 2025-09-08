package uz.pdp.AutoTicket.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.CreateAddressDTO;
import uz.pdp.AutoTicket.dto.request.UpdateAddressDTO;
import uz.pdp.AutoTicket.dto.response.AddressResponseDTO;
import uz.pdp.AutoTicket.service.AddressService;
import uz.pdp.AutoTicket.utils.Constants;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 07/09/2025 08:37
 */
@RestController
@RequestMapping(Constants.BASE_PATH + "address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<Response<AddressResponseDTO>> create(@Valid @RequestBody CreateAddressDTO dto) {
        return ResponseEntity.ok(addressService.create(dto));
    }

    @PostMapping("/create-all")
    public ResponseEntity<Response<List<AddressResponseDTO>>> createAll(@Valid @RequestBody List<CreateAddressDTO> dto) {
        return ResponseEntity.ok(addressService.createAll(dto));
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
