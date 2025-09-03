package uz.pdp.AutoTicket.service.markers;

import jakarta.validation.constraints.NotNull;
import uz.pdp.AutoTicket.dto.marker.Request;
import uz.pdp.AutoTicket.dto.marker.Response;
import uz.pdp.AutoTicket.entity.BaseEntity;

import java.io.Serializable;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 13:54
 */
public interface GenericUDService<
        ID extends Serializable,
        E extends BaseEntity,
        UP extends Request,
        R extends Response> extends GenericQueryService<ID, E, R> {

    uz.pdp.AutoTicket.dto.Response<R> update(@NotNull UP dto);

    uz.pdp.AutoTicket.dto.Response<Boolean> delete(@NotNull ID id);

}
