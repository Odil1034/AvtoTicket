package uz.pdp.AvtoTicket.mapper;

import uz.pdp.AvtoTicket.dto.marker.Request;
import uz.pdp.AvtoTicket.dto.marker.Response;
import uz.pdp.AvtoTicket.entity.BaseEntity;

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

    E from(UP dto);

}
