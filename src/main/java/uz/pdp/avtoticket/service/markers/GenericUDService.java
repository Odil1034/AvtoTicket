package uz.pdp.avtoticket.service.markers;

import jakarta.validation.constraints.NotNull;
import uz.pdp.avtoticket.dto.marker.Request;
import uz.pdp.avtoticket.dto.marker.Response;
import uz.pdp.avtoticket.entity.BaseEntity;

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

    uz.pdp.avtoticket.dto.Response<R> update(@NotNull UP dto);

    uz.pdp.avtoticket.dto.Response<Boolean> delete(@NotNull ID id);

}
