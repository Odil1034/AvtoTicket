package uz.pdp.AvtoTicket.service.addressService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.AvtoTicket.dto.response.AddressDTO;
import uz.pdp.AvtoTicket.dto.request.create.CreateAddressDTO;
import uz.pdp.AvtoTicket.dto.request.update.UpdateAddressDTO;
import uz.pdp.AvtoTicket.entity.address.Address;
import uz.pdp.AvtoTicket.exceptions.IsDeletedException;
import uz.pdp.AvtoTicket.exceptions.NotFoundException;
import uz.pdp.AvtoTicket.mapper.AddressMapper;
import uz.pdp.AvtoTicket.repository.AddressRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImp implements AddressService {

    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;

    @Override
    public AddressDTO create(CreateAddressDTO dto) {
        Address entity = addressMapper.toEntity(dto);
        System.out.println(entity);
        Address save = addressRepository.save(entity);
//        return addressMapper.toDTO(save);
        return new AddressDTO(save.getId(), save.getRegion(), save.getCity(), save.getDistrict(), save.getLongitude(), save.getLatitude());
    }

    @Override
    public AddressDTO getById(Long id) {
        Address byId = findById(id);
//        return addressMapper.toDTO(byId);
        return null;
    }

    @Override
    public List<AddressDTO> getAll() {
        List<Address> all = addressRepository.findAll();
//        return addressMapper.toDTOList(all);
        return List.of();
    }

    @Override
    public boolean delete(Long id) {
        Address byId = findById(id);
        byId.setDeleted(true);
        addressRepository.save(byId);
        return true;
    }

    @Override
    public AddressDTO update(Long addressId, UpdateAddressDTO dto) {
        Address byId = findById(addressId);
//        addressMapper.toUpdate(byId, dto);
        Address save = addressRepository.save(byId);
//        return addressMapper.toDTO(save);
        return null;
    }

    @Override
    public Address findById(Long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new NotFoundException("Address not found with id : " + addressId));
        if (!address.isDeleted()) {
            return address;
        } else {
            throw new IsDeletedException("Address is deleted with id = " + addressId);
        }
    }
}
