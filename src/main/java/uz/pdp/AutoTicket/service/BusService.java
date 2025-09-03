package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.request.bus.BusCreateDTO;
import uz.pdp.AutoTicket.dto.request.bus.BusUpdateDTO;
import uz.pdp.AutoTicket.dto.response.bus.BusResponseDTO;
import uz.pdp.AutoTicket.entity.Bus;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 11:07
 */
public interface BusService extends GenericCruidService<Long, Bus, BusResponseDTO, BusCreateDTO, BusUpdateDTO>  {
}
