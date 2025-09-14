package uz.pdp.avtoticket.service.imp;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.avtoticket.dto.ErrorResponse;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.address.CreateRegionDTO;
import uz.pdp.avtoticket.dto.request.address.UpdateRegionDTO;
import uz.pdp.avtoticket.dto.response.address.CountryResponseDTO;
import uz.pdp.avtoticket.dto.response.address.RegionResponseDTO;
import uz.pdp.avtoticket.entity.address.Country;
import uz.pdp.avtoticket.entity.address.Region;
import uz.pdp.avtoticket.exceptions.ResourceNotFoundException;
import uz.pdp.avtoticket.exceptions.UserNotFoundException;
import uz.pdp.avtoticket.mapper.RegionMapper;
import uz.pdp.avtoticket.repository.address.CountryRepository;
import uz.pdp.avtoticket.repository.address.RegionRepository;
import uz.pdp.avtoticket.service.CountryService;
import uz.pdp.avtoticket.service.RegionService;
import uz.pdp.avtoticket.service.markers.AbstractService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 14:50
 */
@Service
public class RegionServiceImp extends AbstractService<RegionRepository, RegionMapper> implements RegionService {
    private final CountryRepository countryRepository;

    public RegionServiceImp(RegionRepository repository, RegionMapper mapper, CountryRepository countryRepository) {
        super(repository, mapper);
        this.countryRepository = countryRepository;
    }

    @Override
    public Response<RegionResponseDTO> create(CreateRegionDTO dto) {
        Optional<Region> existingRegion = repository.findBySoatoIdAndNameUz(dto.soatoId(), dto.nameUz());
        if (existingRegion.isPresent()) {
            return Response.error(
                    HttpStatus.BAD_REQUEST,
                    ErrorResponse.of(
                            "400",
                            "/region/create",
                            "/avtoticket/region/create",
                            getClass().getSimpleName(),
                            "Region already exists"
                    )
            );
        }
        Country country = countryRepository.findByIdCustom(dto.countryId())
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id {0}", dto.countryId()));

        Region newRegion = Region.builder()
                .country(country)
                .soatoId(dto.soatoId())
                .nameUz(dto.nameUz())
                .nameRu(dto.nameRu())
                .nameOz(dto.nameOz())
                .build();

        Region saved = repository.save(newRegion);
        return Response.ok(HttpStatus.CREATED, mapper.toDto(saved));
    }


    @Override
    public Response<RegionResponseDTO> update(UpdateRegionDTO dto) {
        Region region = repository.findByIdCustom(dto.id())
                .orElseThrow(() -> new UserNotFoundException(
                        "Region not found with id: {0}", dto.id()));
        region.setNameOz(region.getNameOz());
        region.setNameRu(region.getNameRu());
        region.setNameUz(region.getNameUz());
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
                .orElseThrow(() -> new ResourceNotFoundException("Region not with id  {0}", id))));
    }

    @Override
    public Response<List<RegionResponseDTO>> findAll() {
        return Response.ok(repository.findAllCustom().stream()
                .map(mapper::toDto)
                .toList());
    }

    @Override
    public Response<List<RegionResponseDTO>> createAll(List<CreateRegionDTO> dto) {
        List<RegionResponseDTO> regions = new ArrayList<>();
        for (CreateRegionDTO createRegionDTO : dto) {
            regions.add(create(createRegionDTO).getData());
        }
        return Response.ok(regions);
    }
}
