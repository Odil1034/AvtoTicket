package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.*;
import uz.pdp.AvtoTicket.dto.response.BusDTO;
import uz.pdp.AvtoTicket.entity.bus.Bus;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BusMapper extends EntityMapper<BusDTO, Bus> {
    @Override
    Bus toEntity(BusDTO dto);

    @Override
    BusDTO toDto(Bus entity);

    @Override
    List<Bus> toEntity(List<BusDTO> list);

    @Override
    List<BusDTO> toDto(List<Bus> list);
}
