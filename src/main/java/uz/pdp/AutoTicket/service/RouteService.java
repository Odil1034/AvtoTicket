package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.CreateRouteDTO;
import uz.pdp.AutoTicket.dto.request.UpdateRouteDTO;
import uz.pdp.AutoTicket.dto.response.RouteResponseDTO;
import uz.pdp.AutoTicket.entity.Route;
import uz.pdp.AutoTicket.service.markers.GenericCruidService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 10:56
 */
public interface RouteService
        extends GenericCruidService<Long, Route, RouteResponseDTO, CreateRouteDTO, UpdateRouteDTO> {
    // yangi marshrut qo‘shish.
    Response<RouteResponseDTO> createRoute(CreateRouteDTO dto);

    // marshrutlarni qidirish.
    Response<List<RouteResponseDTO>> getAvailableRoutes(String from, String to, LocalDate date);

    // marshrutga avtobus biriktirish.
    Response<RouteResponseDTO> assignBusToRoute(Long routeId, Long busId);

    // marshrut vaqtini hisoblash.
    Response<LocalTime> calculateTravelTime(Long routeId);
}
