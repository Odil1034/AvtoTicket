package uz.pdp.AutoTicket.dto.response;

import uz.pdp.AutoTicket.dto.marker.Response;
import uz.pdp.AutoTicket.enums.PaymentStatus;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 12:46
 */
public record OrderResponseDTO(
        Long id,
        Long ownerId,
        PaymentStatus status,        // BOOKED, CANCELLED, PAID
        Double totalPrice,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<TicketListDTO> tickets
) implements Response {

}