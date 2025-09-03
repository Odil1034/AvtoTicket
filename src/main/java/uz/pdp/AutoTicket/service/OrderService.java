package uz.pdp.AutoTicket.service;

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
    boolean payOrder(Long orderId);

    // To‘lanmagan buyurtmalarni olish
    List<OrderResponseDTO> getUnpaidOrders();

    // Buyurtma statusini o‘zgartirish
    boolean updateOrderStatus(Long orderId, String status);

    // Foydalanuvchining barcha buyurtmalarini olish
    List<OrderResponseDTO> getOrdersByUserId(Long userId);

    // Foydalanuvchining to‘lanmagan buyurtmalari
    List<OrderResponseDTO> getUnpaidOrdersByUser(Long userId);

    // Bir necha buyurtmalarni bekor qilish
    void cancelOrders(List<Long> orderIds);

    // Ticketlar bilan bog‘liq
    List<TicketResponseDTO> getTicketsByOrder(Long orderId);

    // Buyurtmalarni sana bo‘yicha olish
    List<OrderResponseDTO> getOrdersBetweenDates(LocalDate start, LocalDate end);

    // Eng ko‘p buyurtma qilingan product yoki trip
    Map<Long, Long> getMostOrderedTrips(int topN);

    // Buyurtmalar summasi
    Double getTotalRevenue();

    // Bir necha buyurtmalarni tasdiqlash yoki to‘lash
    void payOrders(List<Long> orderIds);
}
