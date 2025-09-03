package uz.pdp.AutoTicket.service;

import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.CreateBusModelDTO;
import uz.pdp.AutoTicket.dto.request.UpdateBusModelDTO;
import uz.pdp.AutoTicket.dto.response.BusModelResponseDTO;
import uz.pdp.AutoTicket.entity.BusModel;
import uz.pdp.AutoTicket.enums.BusModelStatus;
import uz.pdp.AutoTicket.service.markers.GenericCruidService;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 12:09
 */
public interface BusModelService
        extends GenericCruidService<Long, BusModel, BusModelResponseDTO, CreateBusModelDTO, UpdateBusModelDTO> {

    // Model nomi bo‘yicha qidiruv
    Response<List<BusModelResponseDTO>> searchByModelName(String modelName);

    // Max o‘rindiq soni bo‘yicha filtrlash
    Response<List<BusModelResponseDTO>> getModelsBySeatCount(int seatCount);

    // Yiliga ko‘ra filtrlash
    Response<List<BusModelResponseDTO>> getModelsByYear(int year);

    // Eng ko‘p ishlatiladigan model
    Response<BusModelResponseDTO> getMostUsedModel();

    // Modelga tegishli buslar soni
    Response<Integer> getBusCountByModelId(Long modelId);

    // Model statusini yangilash (active/inactive)
    Response<Boolean> updateBusModelStatus(Long modelId, BusModelStatus status);


}
