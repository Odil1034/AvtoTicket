package uz.pdp.avtoticket.controller.address;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.address.UpdateRegionDTO;
import uz.pdp.avtoticket.dto.request.address.CreateRegionDTO;
import uz.pdp.avtoticket.dto.response.address.RegionResponseDTO;
import uz.pdp.avtoticket.service.RegionService;
import uz.pdp.avtoticket.utils.Constants;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 14:17
 */

@RestController
@RequestMapping(Constants.BASE_PATH + "region")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @PostMapping("create")
    private ResponseEntity<Response<RegionResponseDTO>> create(@Valid @RequestBody CreateRegionDTO dto) {
        return ResponseEntity.ok(regionService.create(dto));
    }

    @PostMapping("create-all")
    private ResponseEntity<Response<List<RegionResponseDTO>>> createAll(@Valid @RequestBody List<CreateRegionDTO> dto) {
        return ResponseEntity.ok(regionService.createAll(dto));
    }

    @GetMapping("get/{id}")
    private ResponseEntity<Response<RegionResponseDTO>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(regionService.find(id));
    }

    @PutMapping("update")
    private ResponseEntity<Response<RegionResponseDTO>> update(@Valid @RequestBody UpdateRegionDTO dto) {
        return ResponseEntity.ok(regionService.update(dto));
    }

    @DeleteMapping("delete/{id}")
    private ResponseEntity<Response<Boolean>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(regionService.delete(id));
    }

    @GetMapping("getAll")
    private ResponseEntity<Response<List<RegionResponseDTO>>> getAllCountries() {
        return ResponseEntity.ok(regionService.findAll());
    }
}
