package uz.pdp.AvtoTicket.service.cardService;

import uz.pdp.AvtoTicket.dto.card.CardResponseDTO;
import uz.pdp.AvtoTicket.dto.card.CreateCardDTO;
import uz.pdp.AvtoTicket.dto.card.UpdateCardDTO;
import uz.pdp.AvtoTicket.entity.card.Card;
import uz.pdp.AvtoTicket.service.BaseService;

public interface CardService extends BaseService<Card, CreateCardDTO, UpdateCardDTO, CardResponseDTO> {

}
