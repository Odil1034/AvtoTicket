package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.Mapper;
import uz.pdp.AvtoTicket.dto.response.OrderDTO;
import uz.pdp.AvtoTicket.entity.order.Order;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper extends EntityMapper<OrderDTO, Order> {
    @Override
    Order toEntity(OrderDTO dto);

    @Override
    OrderDTO toDto(Order entity);

    @Override
    List<Order> toEntity(List<OrderDTO> list);

    @Override
    List<OrderDTO> toDto(List<Order> list);
}
