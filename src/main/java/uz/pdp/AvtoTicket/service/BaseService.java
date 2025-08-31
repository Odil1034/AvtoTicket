package uz.pdp.AvtoTicket.service;

import uz.pdp.AvtoTicket.dto.marker.DTO;
import uz.pdp.AvtoTicket.entity.BaseEntity;

import java.util.List;

public interface BaseService<T extends BaseEntity,
        CreateDTO extends DTO,
        UpdateDTO extends DTO,
        ResponseDTO extends DTO> {

    ResponseDTO create(CreateDTO dto);

    ResponseDTO getById(Long id);

    List<ResponseDTO> getAll();

    boolean delete(Long id);

    ResponseDTO update(Long id, UpdateDTO dto);

    T findById(Long id);
}
