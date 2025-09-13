package uz.pdp.avtoticket.service.imp;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.address.CreateCountryDTO;
import uz.pdp.avtoticket.dto.request.address.UpdateCountryDTO;
import uz.pdp.avtoticket.dto.response.address.CountryResponseDTO;
import uz.pdp.avtoticket.entity.address.Country;
import uz.pdp.avtoticket.enums.CountryNames;
import uz.pdp.avtoticket.exceptions.ResourceNotFoundException;
import uz.pdp.avtoticket.exceptions.UserNotFoundException;
import uz.pdp.avtoticket.mapper.CountryMapper;
import uz.pdp.avtoticket.repository.address.CountryRepository;
import uz.pdp.avtoticket.service.CountryService;
import uz.pdp.avtoticket.service.markers.AbstractService;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 14:50
 */
@Service
public class CountryServiceImp extends AbstractService<CountryRepository, CountryMapper> implements CountryService {
    public CountryServiceImp(CountryRepository repository, CountryMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Response<CountryResponseDTO> create(CreateCountryDTO dto) {
        Country country = mapper.fromCreate(dto);
        Country save = repository.save(country);
        return Response.ok(HttpStatus.CREATED, mapper.toDto(save));
    }

    @Override
    public Response<CountryResponseDTO> update(UpdateCountryDTO dto) {
        Country country = repository.findByIdCustom(dto.id())
                .orElseThrow(() -> new UserNotFoundException("Country not found with id: {0}", dto.id()));
        country.setName(dto.name());
        Country save = repository.save(country);
        return Response.ok(200, mapper.toDto(save), "Country updated successfully");
    }

    @Override
    public Response<Boolean> delete(Long id) {
        repository.deleteByIdCustom(id);
        return Response.ok(true);
    }

    @Override
    public Response<CountryResponseDTO> find(Long id) {
        return Response.ok(mapper.toDto(repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not with id {}", id))));
    }

    @Override
    public Response<List<CountryResponseDTO>> findAll() {
        return Response.ok(repository.findAllCustom().stream()
                .map(mapper::toDto)
                .toList());
    }

    @Override
    public Country getCountryOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id {}", id));
    }
}
