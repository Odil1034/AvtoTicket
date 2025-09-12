package uz.pdp.avtoticket.mapper;

import org.mapstruct.Mapper;
import uz.pdp.avtoticket.dto.request.CreateSeatDTO;
import uz.pdp.avtoticket.dto.request.UpdateSeatDTO;
import uz.pdp.avtoticket.dto.response.SeatResponseDTO;
import uz.pdp.avtoticket.entity.Seat;

/**
 * @author Baxriddinov Odiljon
 * @since 12/09/2025 08:57
 */
@Mapper(componentModel = "spring")
public interface SeatMapper extends GenericMapper<Seat, SeatResponseDTO, CreateSeatDTO, UpdateSeatDTO> {

}
