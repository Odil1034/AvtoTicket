package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uz.pdp.AvtoTicket.dto.seat.SeatResponseDTO;
import uz.pdp.AvtoTicket.dto.seat.CreateSeatDTO;
import uz.pdp.AvtoTicket.dto.seat.UpdateSeatDTO;
import uz.pdp.AvtoTicket.entity.seat.Seat;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SeatMapper {

    Seat toEntity(CreateSeatDTO dto);

    Seat toEntity(SeatResponseDTO dto);

    SeatResponseDTO toDTO(Seat seat);

    List<SeatResponseDTO> toDTOList(List<Seat> seat);

    void toUpdate(@MappingTarget Seat seat, UpdateSeatDTO dto);
}
