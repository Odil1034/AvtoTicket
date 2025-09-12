package uz.pdp.avtoticket.dto.request;

import uz.pdp.avtoticket.dto.marker.Request;
import uz.pdp.avtoticket.enums.PaymentStatus;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 12:55
 */
public record UpdateOrderDTO(
        Long orderId,
        PaymentStatus paymentStatus
) implements Request {
}
