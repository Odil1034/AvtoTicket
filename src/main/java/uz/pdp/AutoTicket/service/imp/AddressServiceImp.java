package uz.pdp.AutoTicket.service.imp;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.CreateAddressDTO;
import uz.pdp.AutoTicket.dto.request.UpdateAddressDTO;
import uz.pdp.AutoTicket.dto.response.AddressResponseDTO;
import uz.pdp.AutoTicket.exceptions.ResourceNotFoundException;
import uz.pdp.AutoTicket.mapper.AddressMapper;
import uz.pdp.AutoTicket.repository.AddressRepository;
import uz.pdp.AutoTicket.service.AddressService;
import uz.pdp.AutoTicket.service.markers.AbstractService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 07/09/2025 08:16
 */

@Service
public class AddressServiceImp extends AbstractService<AddressRepository, AddressMapper> implements AddressService {
    public AddressServiceImp(AddressRepository repository, AddressMapper mapper) {
        super(repository, mapper);
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
    public Response<List<AddressResponseDTO>> getAddressesByCity(String city) {
        return null;
    }

    @Override
    public Response<List<AddressResponseDTO>> searchAddresses(String query) {
        return null;
    }

    @Override
    public Response<Void> setDefaultAddress(Long userId, Long addressId) {
        return null;
    }

    @Override
    public Response<AddressResponseDTO> getDefaultAddress(Long userId) {
        return null;
    }

    @Override
    public Response<List<AddressResponseDTO>> createAll(List<CreateAddressDTO> dto) {
        List<AddressResponseDTO> addressResponseDTOS = new ArrayList<>();
        for (CreateAddressDTO createAddressDTO : dto) {
            addressResponseDTOS.add(create(createAddressDTO).getData());
        }
        return Response.ok(HttpStatus.CREATED, addressResponseDTOS);
    }

    @Override
    public Response<AddressResponseDTO> create(CreateAddressDTO dto) {
        Address address = mapper.fromCreate(dto);
        Address save = repository.save(address);
        return Response.ok(HttpStatus.CREATED, mapper.toDto(save));
    }

    @Override
    public Response<AddressResponseDTO> update(UpdateAddressDTO dto) {
        Address address = repository.findByIdCustom(dto.id())
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id {0}", dto.id()));
        mapper.updateEntityFromDto(dto, address);
        Address save = repository.save(address);
        return Response.ok(HttpStatus.ACCEPTED, mapper.toDto(save));
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
