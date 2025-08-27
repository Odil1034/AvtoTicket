package uz.pdp.AvtoTicket.service;

import uz.pdp.AvtoTicket.dto.BaseDTO;
import uz.pdp.AvtoTicket.entity.BaseEntity;

import java.util.List;

public interface BaseService<T extends BaseEntity,
        CreateDTO extends BaseDTO,
        UpdateDTO extends BaseDTO,
        ResponseDTO extends BaseDTO> {

    ResponseDTO create(CreateDTO dto);

    ResponseDTO getById(Long id);

    List<ResponseDTO> getAll();

    boolean delete(Long id);

    ResponseDTO update(Long id, UpdateDTO dto);

    T findById(Long id);
}
