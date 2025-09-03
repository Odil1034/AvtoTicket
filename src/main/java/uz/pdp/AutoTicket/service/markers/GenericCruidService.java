package uz.pdp.AutoTicket.service.markers;

import jakarta.validation.constraints.NotNull;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.marker.Request;
import uz.pdp.AutoTicket.entity.BaseEntity;

import java.io.Serializable;

/**
 * @author Baxriddinov Odiljon
 * @since 31/08/2025 20:36
 */
public interface GenericCruidService<
        ID extends Serializable,
        E extends BaseEntity,
        R extends uz.pdp.AutoTicket.dto.marker.Response,
        CR extends Request,
        UP extends Request>
        extends GenericQueryService<ID, E, R>, GenericService {

    Response<R> create(@NotNull CR dto);

    Response<R> update(@NotNull UP dto);

    Response<Boolean> delete(@NotNull ID id);
}
