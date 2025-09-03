package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.request.CreateOrderDTO;
import uz.pdp.AutoTicket.dto.request.UpdateOrderDTO;
import uz.pdp.AutoTicket.dto.response.OrderResponseDTO;
import uz.pdp.AutoTicket.entity.Order;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 12:45
 */
public interface OrderService extends GenericCruidService<Long, Order, OrderResponseDTO, CreateOrderDTO, UpdateOrderDTO> {
}
