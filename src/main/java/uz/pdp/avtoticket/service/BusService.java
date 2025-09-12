package uz.pdp.avtoticket.service;

import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.bus.BusCreateDTO;
import uz.pdp.avtoticket.dto.request.bus.BusUpdateDTO;
import uz.pdp.avtoticket.dto.response.BusModelResponseDTO;
import uz.pdp.avtoticket.dto.response.SeatResponseDTO;
import uz.pdp.avtoticket.dto.response.TripResponseDTO;
import uz.pdp.avtoticket.dto.response.bus.BusResponseDTO;
import uz.pdp.avtoticket.entity.Bus;
import uz.pdp.avtoticket.enums.BusStatus;
import uz.pdp.avtoticket.service.markers.GenericCruidService;

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

    // Modelga tegishli buslar soni
    Response<Integer> getBusCountByModelId(Long modelId);

    // Max o‘rindiq soni bo‘yicha filtrlash
    Response<List<BusModelResponseDTO>> getModelsBySeatCount(int seatCount);
}