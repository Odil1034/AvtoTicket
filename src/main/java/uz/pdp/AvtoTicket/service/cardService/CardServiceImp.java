package uz.pdp.AvtoTicket.service.cardService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.AvtoTicket.dto.response.CardDTO;
import uz.pdp.AvtoTicket.dto.request.create.CreateCardDTO;
import uz.pdp.AvtoTicket.dto.request.update.UpdateCardDTO;
import uz.pdp.AvtoTicket.entity.card.Card;
import uz.pdp.AvtoTicket.exceptions.IsDeletedException;
import uz.pdp.AvtoTicket.exceptions.NotFoundException;
import uz.pdp.AvtoTicket.mapper.CardMapper;
import uz.pdp.AvtoTicket.repository.CardRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImp implements CardService {
    private final CardMapper cardMapper;
    private final CardRepository cardRepository;

    @Override
    public CardDTO create(CreateCardDTO dto) {
        Card entity = cardMapper.toEntity(dto);
        Card save = cardRepository.save(entity);
        return cardMapper.toDTO(save);
    }

    @Override
    public CardDTO getById(Long id) {
        Card byId = findById(id);
        return cardMapper.toDTO(byId);
    }

    @Override
    public List<CardDTO> getAll() {
        List<Card> all = cardRepository.findAll();
        return cardMapper.toDTOList(all);
    }

    @Override
    public boolean delete(Long id) {
        Card byId = findById(id);
        byId.setDeleted(true);
        cardRepository.save(byId);
        return true;
    }

    @Override
    public CardDTO update(Long cardId, UpdateCardDTO dto) {
        Card byId = findById(cardId);
        cardMapper.toUpdate(byId, dto);
        Card save = cardRepository.save(byId);
        return cardMapper.toDTO(save);
    }

    @Override
    public Card findById(Long cardId) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new NotFoundException("Card not found with id : " + cardId));
        if (!card.isDeleted()) {
            return card;
        } else {
            throw new IsDeletedException("Card is deleted with id = " + cardId);
        }
    }
}
