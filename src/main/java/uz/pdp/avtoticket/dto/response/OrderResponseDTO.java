package uz.pdp.avtoticket.dto.response;

import uz.pdp.avtoticket.dto.marker.Response;
import uz.pdp.avtoticket.dto.response.ticket.TicketResponseDTO;
import uz.pdp.avtoticket.enums.PaymentStatus;

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
        List<TicketResponseDTO> tickets
) implements Response {

}