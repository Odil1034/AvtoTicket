package uz.pdp.avtoticket.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;
import uz.pdp.avtoticket.dto.marker.Request;
import uz.pdp.avtoticket.enums.SeatStatus;
import uz.pdp.avtoticket.enums.SeatType;

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
