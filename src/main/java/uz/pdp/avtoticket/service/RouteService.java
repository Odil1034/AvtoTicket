package uz.pdp.avtoticket.service;

import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.CreateRouteDTO;
import uz.pdp.avtoticket.dto.request.UpdateRouteDTO;
import uz.pdp.avtoticket.dto.response.RouteResponseDTO;
import uz.pdp.avtoticket.entity.Address;
import uz.pdp.avtoticket.entity.Route;
import uz.pdp.avtoticket.service.markers.GenericCruidService;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 10:56
 */
public interface RouteService
        extends GenericCruidService<Long, Route, RouteResponseDTO, CreateRouteDTO, UpdateRouteDTO> {
    // marshrutlarni qidirish.
    Response<List<RouteResponseDTO>> getAvailableRoutes(String from, String to, LocalDate date);

    // marshrutga avtobus biriktirish.
    Response<RouteResponseDTO> assignBusToRoute(Long routeId, Long busId);

    // marshrut vaqtini hisoblash.
    Response<LocalTime> calculateTravelTime(Long routeId);

    // Marshrutga bir nechta buslar biriktirish (batch)
    Response<RouteResponseDTO> assignBusesToRoute(Long routeId, List<Long> busIds);

    // Bu marshrutga nechta trip rejalashtirilgan
    Response<Integer> getTripCountByRoute(Long routeId);

    // ACTIVE / INACTIVE / CANCELLED
    Response<Boolean> updateRouteStatus(Long routeId, String status);

    // Belgilangan sanadagi vaqti bo‘yicha triplar
    Response<List<RouteResponseDTO>> getRoutesByDateAndTime(LocalDate date, LocalTime time);

    Response<Boolean> cancelRoute(Long routeId);

    double calculateDistance(Address from, Address to);

    String calculateEstimateTime(double distance);

    String generateRouteName(Address from, Address to);
}
