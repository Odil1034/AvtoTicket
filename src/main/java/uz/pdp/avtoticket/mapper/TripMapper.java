package uz.pdp.avtoticket.mapper;

import org.mapstruct.Mapper;
import uz.pdp.avtoticket.dto.request.CreateTripDTO;
import uz.pdp.avtoticket.dto.request.UpdateTripDTO;
import uz.pdp.avtoticket.dto.response.TripResponseDTO;
import uz.pdp.avtoticket.entity.Trip;

/**
 * @author Baxriddinov Odiljon
 * @since 12/09/2025 08:53
 */
@Mapper(componentModel = "spring", uses = {SeatMapper.class, TicketMapper.class})
public interface TripMapper
        extends GenericMapper<Trip, TripResponseDTO, CreateTripDTO, UpdateTripDTO> {

}
