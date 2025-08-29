package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uz.pdp.AvtoTicket.dto.order.OrderCreateDTO;
import uz.pdp.AvtoTicket.dto.order.OrderResponseDTO;
import uz.pdp.AvtoTicket.dto.order.OrderUpdateDTO;
import uz.pdp.AvtoTicket.entity.order.Order;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toEntity(OrderCreateDTO dto);

    Order toEntity(OrderResponseDTO dto);

    OrderResponseDTO toDTO(Order order);

    List<OrderResponseDTO> toDTOList(List<Order> order);

    void toUpdate(@MappingTarget Order order, OrderUpdateDTO dto);

}
