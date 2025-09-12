package uz.pdp.avtoticket.controller.address;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.address.CreateCountryDTO;
import uz.pdp.avtoticket.dto.request.address.UpdateCountryDTO;
import uz.pdp.avtoticket.dto.response.address.CountryResponseDTO;
import uz.pdp.avtoticket.service.CountryService;
import uz.pdp.avtoticket.utils.Constants;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 14:17
 */

@RestController
@RequestMapping(Constants.BASE_PATH + "country")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @PostMapping("create")
    private ResponseEntity<Response<CountryResponseDTO>> create(@Valid @RequestBody CreateCountryDTO dto) {
        return ResponseEntity.ok(countryService.create(dto));
    }

    @GetMapping("get/{id}")
    private ResponseEntity<Response<CountryResponseDTO>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.find(id));
    }

    @PutMapping("update")
    private ResponseEntity<Response<CountryResponseDTO>> update(@Valid @RequestBody UpdateCountryDTO dto) {
        return ResponseEntity.ok(countryService.update(dto));
    }

    @DeleteMapping("delete/{id}")
    private ResponseEntity<Response<Boolean>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.delete(id));
    }

    @GetMapping("getAll")
    private ResponseEntity<Response<List<CountryResponseDTO>>> getAllCountries() {
        return ResponseEntity.ok(countryService.findAll());
    }
}
