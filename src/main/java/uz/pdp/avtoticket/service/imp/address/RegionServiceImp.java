package uz.pdp.avtoticket.service.imp.address;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.address.CreateRegionDTO;
import uz.pdp.avtoticket.dto.request.address.UpdateRegionDTO;
import uz.pdp.avtoticket.dto.response.address.RegionResponseDTO;
import uz.pdp.avtoticket.entity.address.Region;
import uz.pdp.avtoticket.exceptions.ResourceNotFoundException;
import uz.pdp.avtoticket.exceptions.UserNotFoundException;
import uz.pdp.avtoticket.mapper.RegionMapper;
import uz.pdp.avtoticket.repository.address.RegionRepository;
import uz.pdp.avtoticket.service.RegionService;
import uz.pdp.avtoticket.service.markers.AbstractService;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 14:50
 */
@Service
public class RegionServiceImp extends AbstractService<RegionRepository, RegionMapper> implements RegionService {
    public RegionServiceImp(RegionRepository repository, RegionMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Response<RegionResponseDTO> create(CreateRegionDTO dto) {
        Region region = mapper.fromCreate(dto);
        Region save = repository.save(region);
        return Response.ok(HttpStatus.CREATED, mapper.toDto(save));
    }

    @Override
    public Response<RegionResponseDTO> update(UpdateRegionDTO dto) {
        Region region = repository.findByIdCustom(dto.id())
                .orElseThrow(() -> new UserNotFoundException(
                        "Region not found with id: {0}", dto.id()));
        mapper.updateEntityFromDto(dto, region);
        Region save = repository.save(region);
        return Response.ok(200, mapper.toDto(save), "Region updated successfully");
    }

    @Override
    public Response<Boolean> delete(Long id) {
        repository.deleteByIdCustom(id);
        return Response.ok(true);
    }

    @Override
    public Response<RegionResponseDTO> find(Long id) {
        return Response.ok(mapper.toDto(repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Region not with id {}", id))));
    }

    @Override
    public Response<List<RegionResponseDTO>> findAll() {
        return Response.ok(repository.findAllCustom().stream()
                .map(mapper::toDto)
                .toList());
    }

    @Override
    public Response<List<RegionResponseDTO>> createAll(List<CreateRegionDTO> dto) {
        List<Region> collect = dto.stream().map(mapper::fromCreate).toList();
        List<Region> regions = repository.saveAll(collect);
        return Response.ok(regions.stream().map(mapper::toDto).toList());
    }
}
