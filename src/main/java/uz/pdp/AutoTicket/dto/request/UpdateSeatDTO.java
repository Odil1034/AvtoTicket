package uz.pdp.AutoTicket.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;
import uz.pdp.AutoTicket.dto.marker.Request;
import uz.pdp.AutoTicket.enums.SeatStatus;
import uz.pdp.AutoTicket.enums.SeatType;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 11:02
 */

@JsonPropertyOrder({"seat_number", "seat_type", "seat_status", "bus_id"})
public record UpdateSeatDTO(
        @JsonProperty("seat_number")
        @NotNull Integer seatNumber,

        @JsonProperty("seat_type")
        SeatType type,

        @JsonProperty("seat_status")
        SeatStatus status,

        @JsonProperty("bus_id")
        @NotNull Long busId
) implements Request {
}
