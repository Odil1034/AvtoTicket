package uz.pdp.avtoticket.mapper;

import uz.pdp.avtoticket.dto.marker.Request;
import uz.pdp.avtoticket.dto.marker.Response;
import uz.pdp.avtoticket.entity.BaseDomain;

/**
 * @author Baxriddinov Odiljon
 * @since 30/08/2025 12:51
 */
public interface GenericMapper<
        E extends BaseDomain,
        R extends Response,
        CR extends Request,
        UP extends Request> extends Mapper {

    R toDto(E entity);

    E toEntity(R dto);

    E fromCreate(CR dto);

    E fromUpdate(UP dto);

}
