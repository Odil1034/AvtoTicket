package uz.pdp.avtoticket.dto.response.bus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import uz.pdp.avtoticket.dto.marker.Response;
import uz.pdp.avtoticket.dto.response.SeatResponseDTO;
import uz.pdp.avtoticket.entity.BusModel;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 11:40
 */

@JsonPropertyOrder({
        "bus_id", "modelName", "manufacturer",
        "countOfSeats", "standingCapacity", "seats"
})
public record BusResponseDTO(
        @JsonProperty("bus_id")
        Long id,

        @JsonProperty("modelName")
        BusModel modelName,

        @JsonProperty("manufacturer")
        String manufacturer,

        @JsonProperty("countOfSeats")
        Integer countOfSeats,

        @JsonProperty("standingCapacity")
        Integer standingCapacity,

        @JsonProperty("plateNumber")
        String plateNumber,  //  10 A321AA UZ


        @JsonProperty("description")
        String description,

        @JsonProperty("seats")
        List<SeatResponseDTO> seats
) implements Response {

}
