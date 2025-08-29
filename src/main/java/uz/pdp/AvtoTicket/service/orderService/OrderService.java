package uz.pdp.AvtoTicket.service.orderService;

import uz.pdp.AvtoTicket.dto.order.OrderCreateDTO;
import uz.pdp.AvtoTicket.dto.order.OrderResponseDTO;
import uz.pdp.AvtoTicket.dto.order.OrderUpdateDTO;
import uz.pdp.AvtoTicket.entity.order.Order;
import uz.pdp.AvtoTicket.service.BaseService;

public interface OrderService extends BaseService<Order, OrderCreateDTO, OrderUpdateDTO, OrderResponseDTO> {

}