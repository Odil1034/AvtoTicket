package uz.pdp.AutoTicket.dto.response.bus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import uz.pdp.AutoTicket.dto.marker.Response;
import uz.pdp.AutoTicket.dto.response.DocumentResponseDTO;
import uz.pdp.AutoTicket.dto.response.SeatResponseDTO;
import uz.pdp.AutoTicket.enums.FuelType;
import uz.pdp.AutoTicket.entity.BusModel;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 11:08
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bus_id", "owner_id", "modelName", "manufacturer", "plateNumber",
        "countOfSeats", "fuelType", "standingCapacity",
        "seats", "documents", "description",
})
public record BusDetailsDTO(
        @JsonProperty("bus_id")
        Long id,

        @JsonProperty("modelName")
        BusModel modelName,

        @JsonProperty("manufacturer")
        String manufacturer,

        @JsonProperty("countOfSeats")
        Integer countOfSeats,

        @JsonProperty("fuelType")
        FuelType fuelType,

        @JsonProperty("standingCapacity")
        Integer standingCapacity,

        @JsonProperty("documents")
        List<DocumentResponseDTO> documents,

        @JsonProperty("owner_id")
        Long ownerId,

        @JsonProperty("description")
        String description,

        @JsonProperty("plateNumber")
        String plateNumber,  //  10 A321AA UZ

        @JsonProperty("seats")
        List<SeatResponseDTO> seats
) implements Response {
}

