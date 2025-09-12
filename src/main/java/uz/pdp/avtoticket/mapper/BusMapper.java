package uz.pdp.avtoticket.mapper;

import org.mapstruct.Mapper;
import uz.pdp.avtoticket.dto.request.bus.BusCreateDTO;
import uz.pdp.avtoticket.dto.request.bus.BusUpdateDTO;
import uz.pdp.avtoticket.dto.response.bus.BusResponseDTO;
import uz.pdp.avtoticket.entity.Bus;

/**
 * @author Baxriddinov Odiljon
 * @since 09/09/2025 07:32
 */

@Mapper(componentModel = "spring")
public interface BusMapper extends GenericMapper<Bus, BusResponseDTO, BusCreateDTO, BusUpdateDTO> {

}
