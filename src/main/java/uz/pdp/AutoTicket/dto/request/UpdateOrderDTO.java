package uz.pdp.AutoTicket.dto.request;

import uz.pdp.AutoTicket.dto.marker.Request;
import uz.pdp.AutoTicket.enums.PaymentStatus;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 12:55
 */
public record UpdateOrderDTO(
        Long orderId,
        PaymentStatus paymentStatus
) implements Request {
}
