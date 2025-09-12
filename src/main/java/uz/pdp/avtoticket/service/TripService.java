package uz.pdp.avtoticket.service;

import uz.pdp.avtoticket.dto.request.CreateTripDTO;
import uz.pdp.avtoticket.dto.request.UpdateTripDTO;
import uz.pdp.avtoticket.dto.response.TripResponseDTO;
import uz.pdp.avtoticket.entity.Trip;
import uz.pdp.avtoticket.service.markers.GenericCruidService;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 13:46
 */
public interface TripService
        extends GenericCruidService<Long, Trip, TripResponseDTO, CreateTripDTO, UpdateTripDTO> {

    // Faqat kelajakdagi triplarni olish
    List<TripResponseDTO> getUpcomingTrips();

    // Faqat o'tgan triplar
    List<TripResponseDTO> getPastTrips();

    // Trip statusini o'zgartirish (active, canceled, completed)
    boolean updateTripStatus(Long tripId, String status);

    // Boshlang'ich va manzil bo'yicha triplarni olish
    List<TripResponseDTO> getTripsByRoute(String fromCity, String toCity);

    // Belgilangan sanadagi triplar
    List<TripResponseDTO> getTripsByDate(LocalDate date);

    // Avtobus bo‘yicha barcha triplar
    List<TripResponseDTO> getTripsByBusId(Long busId);

    // Eng ko‘p chipta sotilgan triplar
    List<TripResponseDTO> getMostBookedTrips(int topN);

    // Trip bo‘yicha sotilgan chipta soni
    int getBookedTicketCount(Long tripId);

    // Bir necha tripni bekor qilish
    void cancelTrips(List<Long> tripIds);
}
