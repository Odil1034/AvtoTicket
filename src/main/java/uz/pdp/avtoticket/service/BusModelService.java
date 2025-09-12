package uz.pdp.avtoticket.service;

import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.CreateBusModelDTO;
import uz.pdp.avtoticket.dto.request.UpdateBusModelDTO;
import uz.pdp.avtoticket.dto.response.BusModelResponseDTO;
import uz.pdp.avtoticket.entity.BusModel;
import uz.pdp.avtoticket.enums.BusModelStatus;
import uz.pdp.avtoticket.service.markers.GenericCruidService;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 12:09
 */
public interface BusModelService
        extends GenericCruidService<Long, BusModel, BusModelResponseDTO, CreateBusModelDTO, UpdateBusModelDTO> {

    // Model nomi bo‘yicha qidiruv
    Response<List<BusModelResponseDTO>> searchByModelName(String modelName);

    // Eng ko‘p ishlatiladigan model
    Response<BusModelResponseDTO> getMostUsedModel();

    // Model statusini yangilash (active/inactive)
    Response<BusModelResponseDTO> updateBusModelStatus(Long modelId, BusModelStatus status);


}
