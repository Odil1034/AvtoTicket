package uz.pdp.AutoTicket.mapper;

import uz.pdp.AutoTicket.dto.marker.Request;
import uz.pdp.AutoTicket.dto.marker.Response;
import uz.pdp.AutoTicket.entity.BaseEntity;

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

}
