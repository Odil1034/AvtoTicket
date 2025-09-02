package uz.pdp.AutoTicket.service.imp;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.CreatePermissionDTO;
import uz.pdp.AutoTicket.dto.request.UpdatePermissionDTO;
import uz.pdp.AutoTicket.dto.response.PermissionResponseDTO;
import uz.pdp.AutoTicket.entity.Permission;
import uz.pdp.AutoTicket.mapper.PermissionMapper;
import uz.pdp.AutoTicket.repository.PermissionRepository;
import uz.pdp.AutoTicket.service.AbstractService;
import uz.pdp.AutoTicket.service.PermissionService;

import java.util.List;
import java.util.Set;

@Service
public class PermissionServiceImp
        extends AbstractService<PermissionRepository, PermissionMapper> implements PermissionService {

    @Lazy
    public PermissionServiceImp(PermissionRepository repository, PermissionMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Response<PermissionResponseDTO> create(CreatePermissionDTO dto) {
        return null;
    }

    @Override
    public Response<PermissionResponseDTO> update(UpdatePermissionDTO dto) {
        return null;
    }

    @Override
    public Response<Boolean> delete(Long aLong) {
        return null;
    }

    @Override
    public Response<PermissionResponseDTO> find(Long aLong) {
        return null;
    }

    @Override
    public Response<List<PermissionResponseDTO>> findAll() {
        return Response.ok(List.of());
    }

    @Override
    public Set<Permission> findAllByIds(List<Long> longs) {
        return Set.of();
    }
}
