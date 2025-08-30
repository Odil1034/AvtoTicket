package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.*;
import uz.pdp.AvtoTicket.dto.bus.BusCreateDTO;
import uz.pdp.AvtoTicket.dto.bus.BusResponseDTO;
import uz.pdp.AvtoTicket.dto.bus.BusUpdateDTO;
import uz.pdp.AvtoTicket.entity.bus.Bus;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BusMapper {

    Bus toEntity(BusCreateDTO dto);

    Bus toEntity(BusResponseDTO dto);

    BusResponseDTO toDTO(Bus bus);

    List<BusResponseDTO> toDTOList(List<Bus> bus);

    void toUpdate(@MappingTarget Bus bus, BusUpdateDTO dto);

}
