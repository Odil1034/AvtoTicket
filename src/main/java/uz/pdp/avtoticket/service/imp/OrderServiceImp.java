package uz.pdp.avtoticket.service.imp;

import org.springframework.stereotype.Service;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.CreateOrderDTO;
import uz.pdp.avtoticket.dto.request.UpdateOrderDTO;
import uz.pdp.avtoticket.dto.response.OrderResponseDTO;
import uz.pdp.avtoticket.dto.response.ticket.TicketResponseDTO;
import uz.pdp.avtoticket.mapper.OrderMapper;
import uz.pdp.avtoticket.repository.OrderRepository;
import uz.pdp.avtoticket.service.OrderService;
import uz.pdp.avtoticket.service.markers.AbstractService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author Baxriddinov Odiljon
 * @since 12/09/2025 08:50
 */
@Service
public class OrderServiceImp extends AbstractService<OrderRepository, OrderMapper> implements OrderService {

    public OrderServiceImp(OrderRepository repository, OrderMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Response<Boolean> payOrder(Long orderId) {
        return null;
    }

    @Override
    public Response<List<OrderResponseDTO>> getUnpaidOrders() {
        return null;
    }

    @Override
    public Response<Boolean> updateOrderStatus(Long orderId, String status) {
        return null;
    }

    @Override
    public Response<List<OrderResponseDTO>> getOrdersByUserId(Long userId) {
        return null;
    }

    @Override
    public Response<List<OrderResponseDTO>> getUnpaidOrdersByUser(Long userId) {
        return null;
    }

    @Override
    public Response<Void> cancelOrders(List<Long> orderIds) {
        return null;
    }

    @Override
    public Response<List<TicketResponseDTO>> getTicketsByOrder(Long orderId) {
        return null;
    }

    @Override
    public Response<List<OrderResponseDTO>> getOrdersBetweenDates(LocalDate start, LocalDate end) {
        return null;
    }

    @Override
    public Response<Map<Long, Long>> getMostOrderedTrips(int topN) {
        return null;
    }

    @Override
    public Response<Double> getTotalRevenue() {
        return null;
    }

    @Override
    public Response<Void> payOrders(List<Long> orderIds) {
        return null;
    }

    @Override
    public Response<OrderResponseDTO> create(CreateOrderDTO dto) {
        return null;
    }

    @Override
    public Response<OrderResponseDTO> update(UpdateOrderDTO dto) {
        return null;
    }

    @Override
    public Response<Boolean> delete(Long aLong) {
        return null;
    }

    @Override
    public Response<OrderResponseDTO> find(Long aLong) {
        return null;
    }

    @Override
    public Response<List<OrderResponseDTO>> findAll() {
        return null;
    }
}
