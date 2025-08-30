package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uz.pdp.AvtoTicket.dto.trip.CreateTripDTO;
import uz.pdp.AvtoTicket.dto.trip.TripResponseDTO;
import uz.pdp.AvtoTicket.dto.trip.UpdateTripDTO;
import uz.pdp.AvtoTicket.entity.trip.Trip;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TripMapper {

    Trip toEntity(CreateTripDTO dto);

    Trip toEntity(TripResponseDTO dto);

    TripResponseDTO toDTO(Trip trip);

    List<TripResponseDTO> toDTOList(List<Trip> trip);

    void toUpdate(@MappingTarget Trip trip, UpdateTripDTO dto);

}
