package uz.pdp.avtoticket.mapper;

import org.mapstruct.Mapper;
import uz.pdp.avtoticket.dto.request.CreateOrderDTO;
import uz.pdp.avtoticket.dto.request.UpdateOrderDTO;
import uz.pdp.avtoticket.dto.response.OrderResponseDTO;
import uz.pdp.avtoticket.entity.Order;

/**
 * @author Baxriddinov Odiljon
 * @since 12/09/2025 08:51
 */

@Mapper(componentModel = "spring")
public interface OrderMapper extends GenericMapper<Order, OrderResponseDTO, CreateOrderDTO, UpdateOrderDTO> {

}
