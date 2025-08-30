package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uz.pdp.AvtoTicket.dto.response.SeatDTO;
import uz.pdp.AvtoTicket.dto.request.update.UpdateSeatDTO;
import uz.pdp.AvtoTicket.entity.seat.Seat;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SeatMapper {
    SeatDTO toDTO(Seat seat);

    List<SeatDTO> toDTOList(List<Seat> seat);

    void toUpdate(@MappingTarget Seat seat, UpdateSeatDTO dto);
}
