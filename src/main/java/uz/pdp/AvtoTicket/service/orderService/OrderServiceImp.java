package uz.pdp.AvtoTicket.service.orderService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.AvtoTicket.dto.request.create.OrderCreateDTO;
import uz.pdp.AvtoTicket.dto.response.OrderDTO;
import uz.pdp.AvtoTicket.dto.request.update.OrderUpdateDTO;
import uz.pdp.AvtoTicket.entity.order.Order;
import uz.pdp.AvtoTicket.exceptions.IsDeletedException;
import uz.pdp.AvtoTicket.exceptions.NotFoundException;
import uz.pdp.AvtoTicket.mapper.OrderMapper;
import uz.pdp.AvtoTicket.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderDTO create(OrderCreateDTO dto) {
        Order entity = orderMapper.toEntity(dto);
        Order save = orderRepository.save(entity);
        return orderMapper.toDTO(save);
    }

    @Override
    public OrderDTO getById(Long id) {
        Order byId = findById(id);
        return orderMapper.toDTO(byId);
    }

    @Override
    public List<OrderDTO> getAll() {
        List<Order> all = orderRepository.findAll();
        return orderMapper.toDTOList(all);
    }

    @Override
    public boolean delete(Long id) {
        Order byId = findById(id);
        byId.setDeleted(true);
        orderRepository.save(byId);
        return true;
    }

    @Override
    public OrderDTO update(Long orderId, OrderUpdateDTO dto) {
        Order byId = findById(orderId);
        orderMapper.toUpdate(byId, dto);
        Order save = orderRepository.save(byId);
        return orderMapper.toDTO(save);
    }

    @Override
    public Order findById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order not found with id : " + orderId));
        if (!order.isDeleted()) {
            return order;
        } else {
            throw new IsDeletedException("Order is deleted with id = " + orderId);
        }
    }
}
