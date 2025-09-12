package uz.pdp.avtoticket.service.imp;

import org.springframework.stereotype.Service;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.card.CreateCardDTO;
import uz.pdp.avtoticket.dto.request.card.UpdateCardDTO;
import uz.pdp.avtoticket.dto.response.card.CardResponseDTO;
import uz.pdp.avtoticket.mapper.CardMapper;
import uz.pdp.avtoticket.repository.CardRepository;
import uz.pdp.avtoticket.service.CardService;
import uz.pdp.avtoticket.service.markers.AbstractService;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 12/09/2025 08:40
 */
@Service
public class CardServiceImp extends AbstractService<CardRepository, CardMapper> implements CardService {

    public CardServiceImp(CardRepository repository, CardMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public boolean validateCard(CreateCardDTO dto) {
        return false;
    }

    @Override
    public Response<List<CardResponseDTO>> getUserCards(Long userId) {
        return null;
    }

    @Override
    public Response<Boolean> sendVerificationCode(Long cardId) {
        return null;
    }

    @Override
    public Response<Boolean> verifyCard(Long cardId, String code) {
        return null;
    }

    @Override
    public Response<Boolean> blockCard(Long cardId) {
        return null;
    }

    @Override
    public Response<Boolean> unblockCard(Long cardId) {
        return null;
    }

    @Override
    public Response<Boolean> setDefaultCard(Long userId, Long cardId) {
        return null;
    }

    @Override
    public Response<CardResponseDTO> create(CreateCardDTO dto) {
        return null;
    }

    @Override
    public Response<CardResponseDTO> update(UpdateCardDTO dto) {
        return null;
    }

    @Override
    public Response<Boolean> delete(Long aLong) {
        return null;
    }

    @Override
    public Response<CardResponseDTO> find(Long aLong) {
        return null;
    }

    @Override
    public Response<List<CardResponseDTO>> findAll() {
        return null;
    }
}
