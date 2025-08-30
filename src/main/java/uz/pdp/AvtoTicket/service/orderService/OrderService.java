package uz.pdp.AvtoTicket.service.orderService;

import uz.pdp.AvtoTicket.dto.request.create.OrderCreateDTO;
import uz.pdp.AvtoTicket.dto.response.OrderDTO;
import uz.pdp.AvtoTicket.dto.request.update.OrderUpdateDTO;
import uz.pdp.AvtoTicket.entity.order.Order;
import uz.pdp.AvtoTicket.service.BaseService;

public interface OrderService extends BaseService<Order, OrderCreateDTO, OrderUpdateDTO, OrderDTO> {

}