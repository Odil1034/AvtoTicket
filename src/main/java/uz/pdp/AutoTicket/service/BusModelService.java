package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.request.CreateBusModelDTO;
import uz.pdp.AutoTicket.dto.request.UpdateBusModelDTO;
import uz.pdp.AutoTicket.dto.response.BusModelResponseDTO;
import uz.pdp.AutoTicket.entity.BusModel;
import uz.pdp.AutoTicket.service.markers.GenericCruidService;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 12:09
 */
public interface BusModelService
        extends GenericCruidService<Long, BusModel, BusModelResponseDTO, CreateBusModelDTO, UpdateBusModelDTO> {
}
