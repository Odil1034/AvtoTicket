package uz.pdp.avtoticket.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.CreateBusModelDTO;
import uz.pdp.avtoticket.dto.request.UpdateBusModelDTO;
import uz.pdp.avtoticket.dto.response.BusModelResponseDTO;
import uz.pdp.avtoticket.service.BusModelService;
import uz.pdp.avtoticket.utils.Constants;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 19:04
 */

@RestController
@RequestMapping(Constants.BASE_PATH + "bus-model")
@RequiredArgsConstructor
public class BusModelController {

    private final BusModelService busModelService;

    @PostMapping("create")
    public ResponseEntity<Response<BusModelResponseDTO>> create(@Valid @RequestBody CreateBusModelDTO dto) {
        return ResponseEntity.ok(busModelService.create(dto));
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Response<BusModelResponseDTO>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(busModelService.find(id));
    }

    @PutMapping("update")
    public ResponseEntity<Response<BusModelResponseDTO>> update(@Valid @RequestBody UpdateBusModelDTO dto) {
        return ResponseEntity.ok(busModelService.update(dto));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Response<Boolean>> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(busModelService.delete(id));
    }

    @GetMapping("get-all")
    public ResponseEntity<Response<List<BusModelResponseDTO>>> getAll() {
        return ResponseEntity.ok(busModelService.findAll());
    }
}
