package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uz.pdp.AvtoTicket.dto.response.TripDTO;
import uz.pdp.AvtoTicket.dto.request.update.UpdateTripDTO;
import uz.pdp.AvtoTicket.entity.trip.Trip;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TripMapper {

    TripDTO toDTO(Trip trip);

    List<TripDTO> toDTOList(List<Trip> trip);

    void toUpdate(@MappingTarget Trip trip, UpdateTripDTO dto);

}
