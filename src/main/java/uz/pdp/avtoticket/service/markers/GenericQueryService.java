package uz.pdp.avtoticket.service.markers;

import jakarta.validation.constraints.NotNull;
import uz.pdp.avtoticket.entity.BaseDomain;
import uz.pdp.avtoticket.dto.Response;

import java.io.Serializable;
import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 31/08/2025 20:39
 */
public interface GenericQueryService<
        ID extends Serializable,
        E extends BaseDomain,
        R extends uz.pdp.avtoticket.dto.marker.Response>
        extends GenericService {

    Response<R> find(@NotNull ID id);

    Response<List<R>> findAll();
}
