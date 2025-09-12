package uz.pdp.avtoticket.service.imp.address;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.address.CreateDistrictDTO;
import uz.pdp.avtoticket.dto.request.address.UpdateDistrictDTO;
import uz.pdp.avtoticket.dto.response.address.DistrictResponseDTO;
import uz.pdp.avtoticket.entity.address.District;
import uz.pdp.avtoticket.entity.address.Region;
import uz.pdp.avtoticket.exceptions.ResourceNotFoundException;
import uz.pdp.avtoticket.exceptions.UserNotFoundException;
import uz.pdp.avtoticket.mapper.DistrictMapper;
import uz.pdp.avtoticket.repository.address.DistrictRepository;
import uz.pdp.avtoticket.repository.address.RegionRepository;
import uz.pdp.avtoticket.service.DistrictService;
import uz.pdp.avtoticket.service.markers.AbstractService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 16:48
 */
@Service
public class DistrictServiceImp
        extends AbstractService<DistrictRepository, DistrictMapper> implements DistrictService {

    private final RegionRepository regionRepository;

    public DistrictServiceImp(DistrictRepository repository, DistrictMapper mapper, RegionRepository regionRepository) {
        super(repository, mapper);
        this.regionRepository = regionRepository;
    }

    public Response<DistrictResponseDTO> create(CreateDistrictDTO dto) {
        Region region = regionRepository.findByIdCustom(dto.regionId())
                .orElseThrow(() -> new ResourceNotFoundException("Region not found with id {}", dto.regionId()));

        District district = mapper.fromCreate(dto);
        district.setRegion(region);

        District save = repository.save(district);
        return Response.ok(HttpStatus.CREATED, mapper.toDto(save));
    }

    @Override
    public Response<DistrictResponseDTO> update(UpdateDistrictDTO dto) {
        District district = repository.findByIdCustom(dto.id())
                .orElseThrow(() -> new UserNotFoundException(
                        "District not found with id: {0}", dto.id()));
        mapper.updateEntityFromDto(dto, district);
        District save = repository.save(district);
        return Response.ok(200, mapper.toDto(save), "District updated successfully");
    }

    @Override
    public Response<Boolean> delete(Long id) {
        repository.deleteByIdCustom(id);
        return Response.ok(true);
    }

    @Override
    public Response<DistrictResponseDTO> find(Long id) {
        return Response.ok(mapper.toDto(repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("District not with id {}", id))));
    }

    @Override
    public Response<List<DistrictResponseDTO>> findAll() {
        return Response.ok(repository.findAllCustom().stream()
                .map(mapper::toDto)
                .toList());
    }

    @Override
    public Response<Void> createAll(List<CreateDistrictDTO> dto) {
        dto.forEach(this::create);
        return Response.ok(null);
    }

    @Override
    public Response<List<DistrictResponseDTO>> findAllByRegionId(Long regionId) {
        List<District> byRegion = repository.findByRegion(regionId);
        return Response.ok(byRegion.stream().map(mapper::toDto).toList());
    }
}
