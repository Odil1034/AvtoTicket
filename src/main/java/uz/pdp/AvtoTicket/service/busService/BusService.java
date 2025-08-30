package uz.pdp.AvtoTicket.service.busService;

import uz.pdp.AvtoTicket.dto.request.create.BusCreateDTO;
import uz.pdp.AvtoTicket.dto.response.BusDTO;
import uz.pdp.AvtoTicket.dto.request.update.BusUpdateDTO;
import uz.pdp.AvtoTicket.entity.bus.Bus;
import uz.pdp.AvtoTicket.service.BaseService;

public interface BusService extends BaseService<Bus, BusCreateDTO, BusUpdateDTO, BusDTO> {

}