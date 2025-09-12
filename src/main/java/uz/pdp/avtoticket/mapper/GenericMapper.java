package uz.pdp.avtoticket.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import uz.pdp.avtoticket.dto.marker.Request;
import uz.pdp.avtoticket.dto.marker.Response;
import uz.pdp.avtoticket.entity.BaseEntity;

/**
 * @author Baxriddinov Odiljon
 * @since 30/08/2025 12:51
 */
public interface GenericMapper<
        E extends BaseEntity,
        R extends Response,
        CR extends Request,
        UP extends Request> extends Mapper {

    R toDto(E entity);

    E toEntity(R dto);

    E fromCreate(CR dto);

    E fromUpdate(UP dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(UP dto, @MappingTarget E entity);
}
