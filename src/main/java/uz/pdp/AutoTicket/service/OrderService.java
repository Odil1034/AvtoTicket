package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.CreateOrderDTO;
import uz.pdp.AutoTicket.dto.request.UpdateOrderDTO;
import uz.pdp.AutoTicket.dto.response.OrderResponseDTO;
import uz.pdp.AutoTicket.dto.response.ticket.TicketResponseDTO;
import uz.pdp.AutoTicket.entity.Order;
import uz.pdp.AutoTicket.service.markers.GenericCruidService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 12:45
 */
public interface OrderService
        extends GenericCruidService<Long, Order, OrderResponseDTO, CreateOrderDTO, UpdateOrderDTO> {

    // Buyurtmani to‘lash
    Response<Boolean> payOrder(Long orderId);

    // To‘lanmagan buyurtmalarni olish
    Response<List<OrderResponseDTO>> getUnpaidOrders();

    // Buyurtma statusini o‘zgartirish
    Response<Boolean> updateOrderStatus(Long orderId, String status);

    // Foydalanuvchining barcha buyurtmalarini olish
    Response<List<OrderResponseDTO>> getOrdersByUserId(Long userId);

    // Foydalanuvchining to‘lanmagan buyurtmalari
    Response<List<OrderResponseDTO>> getUnpaidOrdersByUser(Long userId);

    // Bir necha buyurtmalarni bekor qilish
    Response<Void> cancelOrders(List<Long> orderIds);

    // Ticketlar bilan bog‘liq
    Response<List<TicketResponseDTO>> getTicketsByOrder(Long orderId);

    // Buyurtmalarni sana bo‘yicha olish
    Response<List<OrderResponseDTO>> getOrdersBetweenDates(LocalDate start, LocalDate end);

    // Eng ko‘p buyurtma qilingan product yoki trip
    Response<Map<Long, Long>> getMostOrderedTrips(int topN);

    // Buyurtmalar summasi
    Response<Double> getTotalRevenue();

    // Bir necha buyurtmalarni tasdiqlash yoki to‘lash
    Response<Void> payOrders(List<Long> orderIds);
}
