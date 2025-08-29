package uz.pdp.AvtoTicket.service.busService;

import uz.pdp.AvtoTicket.dto.bus.BusCreateDTO;
import uz.pdp.AvtoTicket.dto.bus.BusResponseDTO;
import uz.pdp.AvtoTicket.dto.bus.BusUpdateDTO;
import uz.pdp.AvtoTicket.entity.bus.Bus;
import uz.pdp.AvtoTicket.service.BaseService;

public interface BusService extends BaseService<Bus, BusCreateDTO, BusUpdateDTO, BusResponseDTO> {

}