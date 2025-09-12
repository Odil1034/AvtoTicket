package uz.pdp.avtoticket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.pdp.avtoticket.dto.request.CreateBusModelDTO;
import uz.pdp.avtoticket.dto.request.UpdateBusModelDTO;
import uz.pdp.avtoticket.dto.response.BusModelResponseDTO;
import uz.pdp.avtoticket.entity.BusModel;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 19:08
 */
@Mapper(componentModel = "spring")
public interface BusModelMapper
        extends GenericMapper<BusModel, BusModelResponseDTO, CreateBusModelDTO, UpdateBusModelDTO> {

    @Override
    @Mapping(target = "manufacturer", expression = "java(entity.getManufacturer().name())")
    BusModelResponseDTO toDto(BusModel entity);


}
