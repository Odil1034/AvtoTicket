package uz.pdp.avtoticket.service.markers;

import lombok.RequiredArgsConstructor;
import uz.pdp.avtoticket.mapper.Mapper;
import uz.pdp.avtoticket.repository.Repository;

/**
 * @author Baxriddinov Odiljon
 * @since 31/08/2025 20:57
 */

@RequiredArgsConstructor
public abstract class AbstractService<R extends Repository, M extends Mapper> {
    protected final R repository;
    protected final M mapper;
}
