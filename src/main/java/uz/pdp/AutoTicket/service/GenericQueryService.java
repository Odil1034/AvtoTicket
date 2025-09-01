package uz.pdp.AutoTicket.service;

import jakarta.validation.constraints.NotNull;
import uz.pdp.AutoTicket.dto.marker.Response;
import uz.pdp.AutoTicket.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 31/08/2025 20:39
 */
public interface GenericQueryService<
    ID extends Serializable,
    E extends BaseEntity,
    R extends Response>
    extends GenericService {

    uz.pdp.AutoTicket.dto.Response<R> find(@NotNull ID id);
    uz.pdp.AutoTicket.dto.Response<List<R>> findAll();
}
