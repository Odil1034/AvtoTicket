package uz.pdp.avtoticket.service.imp;

import lombok.SneakyThrows;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.CreateBusModelDTO;
import uz.pdp.avtoticket.dto.request.UpdateBusModelDTO;
import uz.pdp.avtoticket.dto.response.BusModelResponseDTO;
import uz.pdp.avtoticket.entity.BusModel;
import uz.pdp.avtoticket.enums.BusModelStatus;
import uz.pdp.avtoticket.exceptions.ResourceNotFoundException;
import uz.pdp.avtoticket.exceptions.UserNotFoundException;
import uz.pdp.avtoticket.mapper.BusModelMapper;
import uz.pdp.avtoticket.repository.BusModelRepository;
import uz.pdp.avtoticket.service.BusModelService;
import uz.pdp.avtoticket.service.markers.AbstractService;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 08/09/2025 19:07
 */
@Service
public class BusModelServiceImp extends AbstractService<BusModelRepository, BusModelMapper>
        implements BusModelService {

    public BusModelServiceImp(BusModelRepository repository, BusModelMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Response<List<BusModelResponseDTO>> searchByModelName(String modelName) {
        List<BusModel> busModelsByName = repository.findBusModelsByName(modelName);
        return Response.ok(busModelsByName.stream()
                .map(mapper::toDto)
                .toList());
    }

    @Override
    public Response<BusModelResponseDTO> getMostUsedModel() {
        BusModel mostUsedModel = repository.findMostUsedModel();
        return Response.ok(mapper.toDto(mostUsedModel));
    }

    @Override
    public Response<BusModelResponseDTO> updateBusModelStatus(Long modelId, BusModelStatus status) {
        BusModel busModel = repository.findByIdCustom(modelId)
                .orElseThrow(() -> new UserNotFoundException("BusModel not with id {0} found", modelId));
        busModel.setStatus(status);
        BusModel save = repository.save(busModel);
        return Response.ok(mapper.toDto(save));
    }

    @SneakyThrows
    @Override
    public Response<BusModelResponseDTO> create(CreateBusModelDTO dto) {
        if (!repository.existsByName(dto.getModelName())) {
            BusModel busModel = mapper.fromCreate(dto);
            BusModel save = repository.save(busModel);
            return Response.ok(mapper.toDto(save));
        } else {
            throw new FileAlreadyExistsException("BusModel already exists");
        }
    }

    @Override
    public Response<BusModelResponseDTO> update(UpdateBusModelDTO dto) {
        BusModel busModel = repository.findByIdCustom(dto.id())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "BusModel not found with session id: {0}", dto.id()));
        mapper.updateEntityFromDto(dto, busModel);
        BusModel save = repository.save(busModel);
        return Response.ok(200, mapper.toDto(save), "BusModel updated successfully");
    }

    @Override
    public Response<Boolean> delete(Long id) {
        repository.deleteByIdCustom(id);
        return Response.ok(true);
    }

    @Override
    public Response<BusModelResponseDTO> find(Long id) {
        return Response.ok(mapper.toDto(repository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("BusModel not with id {0} found", id))));
    }

    @Override
    public Response<List<BusModelResponseDTO>> findAll() {
        return Response.ok(repository.findAllCustom().stream()
                .map(mapper::toDto)
                .toList());
    }
}
