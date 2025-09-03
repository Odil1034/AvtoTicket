package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.CreateSeatDTO;
import uz.pdp.AutoTicket.dto.request.UpdateSeatDTO;
import uz.pdp.AutoTicket.dto.response.SeatResponseDTO;
import uz.pdp.AutoTicket.entity.Seat;
import uz.pdp.AutoTicket.service.markers.GenericCruidService;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 10:57
 */
public interface SeatService
        extends GenericCruidService<Long, Seat, SeatResponseDTO, CreateSeatDTO, UpdateSeatDTO> {

    // Belgilangan trip uchun barcha o'rindiqlar
    Response<List<SeatResponseDTO>> getSeatsByTripId(Long tripId);

    // Belgilangan trip uchun bo‘sh o‘rindiqlar
    Response<List<SeatResponseDTO>> getAvailableSeatsByTripId(Long tripId);

    // Foydalanuvchi band qilgan o'rindiqlar
    Response<List<SeatResponseDTO>> getSeatsByUserId(Long userId);

    // Buyurtma asosida o'rindiqlarni olish
    Response<List<SeatResponseDTO>> getSeatsByOrderId(Long orderId);

    // O‘rindiqni band qilish
    Response<Boolean> reserveSeat(Long seatId, Long userId);

    // Band qilingan o‘rindiqni bekor qilish
    Response<Boolean> cancelSeatReservation(Long seatId);

    // O‘rindiq mavjud yoki bandligini tekshirish
    Response<Boolean> isSeatAvailable(Long seatId);

    // Trip bo‘yicha nechta o'rindiq band qilingan
    Response<Integer> getBookedSeatCount(Long tripId);

    // Trip bo‘yicha nechta o'rindiq bo‘sh
    Response<Integer> getAvailableSeatCount(Long tripId);
}
