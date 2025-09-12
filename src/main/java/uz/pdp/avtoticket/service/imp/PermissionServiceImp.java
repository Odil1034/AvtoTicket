package uz.pdp.avtoticket.service.imp;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.CreatePermissionDTO;
import uz.pdp.avtoticket.dto.request.UpdatePermissionDTO;
import uz.pdp.avtoticket.dto.response.PermissionResponseDTO;
import uz.pdp.avtoticket.entity.Permission;
import uz.pdp.avtoticket.mapper.PermissionMapper;
import uz.pdp.avtoticket.repository.PermissionRepository;
import uz.pdp.avtoticket.service.markers.AbstractService;
import uz.pdp.avtoticket.service.PermissionService;

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
    public Response<Boolean> delete(Long id) {
        return null;
    }

    @Override
    public Response<PermissionResponseDTO> find(Long id) {
        return null;
    }

    @Override
    public Response<List<PermissionResponseDTO>> findAll() {
        return Response.ok(List.of());
    }

    @Override
    public Response<Boolean> hasPermission(Long userId, String permission) {
        return null;
    }

    @Override
    public Response<List<PermissionResponseDTO>> getUserPermissions(Long userId) {
        return null;
    }
}
