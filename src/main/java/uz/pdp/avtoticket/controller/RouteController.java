package uz.pdp.avtoticket.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.CreateRouteDTO;
import uz.pdp.avtoticket.dto.response.RouteResponseDTO;
import uz.pdp.avtoticket.service.RouteService;
import uz.pdp.avtoticket.utils.Constants;

/**
 * @author Baxriddinov Odiljon
 * @since 05/09/2025 22:23
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.BASE_PATH + "route")
public class RouteController {

    private final RouteService routeService;

    @PostMapping("/create")
    public ResponseEntity<Response<RouteResponseDTO>> createRoute(@Valid @RequestBody CreateRouteDTO dto) {
        return ResponseEntity.ok(routeService.create(dto));
    }
}
