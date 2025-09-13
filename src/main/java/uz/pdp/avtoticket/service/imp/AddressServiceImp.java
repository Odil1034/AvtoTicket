package uz.pdp.avtoticket.service.imp;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.address.CreateAddressDTO;
import uz.pdp.avtoticket.dto.request.address.UpdateAddressDTO;
import uz.pdp.avtoticket.dto.response.AddressResponseDTO;
import uz.pdp.avtoticket.entity.Address;
import uz.pdp.avtoticket.entity.address.District;
import uz.pdp.avtoticket.exceptions.ResourceNotFoundException;
import uz.pdp.avtoticket.mapper.AddressMapper;
import uz.pdp.avtoticket.repository.address.AddressRepository;
import uz.pdp.avtoticket.repository.address.DistrictRepository;
import uz.pdp.avtoticket.service.AddressService;
import uz.pdp.avtoticket.service.markers.AbstractService;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 12/09/2025 11:17
 */
@Service
public class AddressServiceImp
        extends AbstractService<AddressRepository, AddressMapper> implements AddressService {

    private final DistrictRepository districtRepository;

    public AddressServiceImp(AddressRepository repository, AddressMapper mapper, DistrictRepository districtRepository) {
        super(repository, mapper);
        this.districtRepository = districtRepository;
    }

    @Override
    public Response<List<AddressResponseDTO>> getAddressesByUserId(Long userId) {

        return null;
    }

    @Override
    public Response<List<AddressResponseDTO>> getAddressesByBusId(Long busId) {
        return null;
    }

    @Override
    public Response<List<AddressResponseDTO>> getAddressesByRegion(Long regionId) {
        return null;
    }

    @Override
    public Response<List<AddressResponseDTO>> getAddressesByDistrict(Long districtId) {
        District district = districtRepository.findByIdCustom(districtId)
                .orElseThrow(() -> new ResourceNotFoundException("District not found with id {0}", districtId));
        List<Address> byDistrictId = repository.findByDistrictId(districtId);
        List<AddressResponseDTO> list = byDistrictId.stream().map(mapper::toDto).toList();
        return Response.ok(list);
    }

    @Override
    public Response<AddressResponseDTO> create(CreateAddressDTO dto) {
        District district = districtRepository.findByIdCustom(dto.districtId())
                .orElseThrow(() -> new ResourceNotFoundException("District not found with id {0}", dto.districtId()));
        Address newAddress = Address.builder()
                .district(district)
                .region(district.getRegion())
                .country(district.getRegion().getCountry())
                .longitude(dto.longitude())
                .latitude(dto.latitude())
                .build();
        Address save = repository.save(newAddress);
        return Response.ok(HttpStatus.CREATED, mapper.toDto(save));
    }

    @Override
    public Response<AddressResponseDTO> update(UpdateAddressDTO dto) {
        Address address = repository.findByIdCustom(dto.id())
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id {0}", dto.id()));
        District district = districtRepository.findByIdCustom(dto.districtId())
                .orElseThrow(() -> new ResourceNotFoundException("District not found with id {0}", dto.districtId()));
        address.setDistrict(district);
        address.setRegion(district.getRegion());
        address.setCountry(district.getRegion().getCountry());
        Address save = repository.save(address);
        return Response.ok(HttpStatus.OK, mapper.toDto(save));
    }

    @Override
    public Response<Boolean> delete(Long id) {
        repository.deleteByIdCustom(id);
        return Response.ok(true);
    }

    @Override
    public Response<AddressResponseDTO> find(Long id) {
        Address address = repository.findByIdCustom(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id {0}", id));
        return Response.ok(mapper.toDto(address));
    }

    @Override
    public Response<List<AddressResponseDTO>> findAll() {
        return Response.ok(repository.findAllCustom().stream()
                .map(mapper::toDto)
                .toList());
    }
}
