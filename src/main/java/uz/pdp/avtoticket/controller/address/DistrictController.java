package uz.pdp.avtoticket.controller.address;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.address.CreateDistrictDTO;
import uz.pdp.avtoticket.dto.request.address.UpdateDistrictDTO;
import uz.pdp.avtoticket.dto.response.address.DistrictResponseDTO;
import uz.pdp.avtoticket.service.DistrictService;
import uz.pdp.avtoticket.utils.Constants;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 14:17
 */
@RestController
@RequestMapping(Constants.BASE_PATH + "district")
@RequiredArgsConstructor
public class DistrictController {

    private final DistrictService districtService;

    @PostMapping("create")
    private ResponseEntity<Response<DistrictResponseDTO>> create(@Valid @RequestBody CreateDistrictDTO dto) {
        return ResponseEntity.ok(districtService.create(dto));
    }

    @PostMapping("create-all")
    private ResponseEntity<Response<List<DistrictResponseDTO>>> createAll(@Valid @RequestBody List<CreateDistrictDTO> dto) {
        return ResponseEntity.ok(districtService.createAll(dto));
    }

    @GetMapping("get/{id}")
    private ResponseEntity<Response<DistrictResponseDTO>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(districtService.find(id));
    }

    @PutMapping("update")
    private ResponseEntity<Response<DistrictResponseDTO>> update(@Valid @RequestBody UpdateDistrictDTO dto) {
        return ResponseEntity.ok(districtService.update(dto));
    }

    @DeleteMapping("delete/{id}")
    private ResponseEntity<Response<Boolean>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(districtService.delete(id));
    }

    @GetMapping("getAll")
    private ResponseEntity<Response<List<DistrictResponseDTO>>> getAllCountries() {
        return ResponseEntity.ok(districtService.findAll());
    }
}
