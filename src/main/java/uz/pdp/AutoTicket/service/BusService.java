package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.bus.BusCreateDTO;
import uz.pdp.AutoTicket.dto.request.bus.BusUpdateDTO;
import uz.pdp.AutoTicket.dto.response.SeatResponseDTO;
import uz.pdp.AutoTicket.dto.response.TripResponseDTO;
import uz.pdp.AutoTicket.dto.response.bus.BusResponseDTO;
import uz.pdp.AutoTicket.entity.Bus;
import uz.pdp.AutoTicket.enums.BusStatus;
import uz.pdp.AutoTicket.service.markers.GenericCruidService;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 11:07
 */
public interface BusService extends GenericCruidService<Long, Bus, BusResponseDTO, BusCreateDTO, BusUpdateDTO> {

    // avtobusga driver biriktirish.
    Response<Boolean> assignDriver(Long busId, Long driverId);

    // avtobusdan driverni olib tashlash.
    Response<BusResponseDTO> releaseDriver(Long busId);

    // avtobus jadvalini ko‘rish.
    Response<List<TripResponseDTO>> getBusTrips(Long busId);

    // bo‘sh o‘rinlarni ko‘rish.
    Response<List<SeatResponseDTO>> getAvailableSeats(Long busId, LocalDate date);

    // Bus statusini yangilash (availability/maintenance)
    Response<Boolean> updateBusModelStatus(Long modelId, BusStatus status);

}