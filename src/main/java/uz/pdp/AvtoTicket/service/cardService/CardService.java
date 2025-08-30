package uz.pdp.AvtoTicket.service.cardService;

import uz.pdp.AvtoTicket.dto.response.CardDTO;
import uz.pdp.AvtoTicket.dto.request.create.CreateCardDTO;
import uz.pdp.AvtoTicket.dto.request.update.UpdateCardDTO;
import uz.pdp.AvtoTicket.entity.card.Card;
import uz.pdp.AvtoTicket.service.BaseService;

public interface CardService extends BaseService<Card, CreateCardDTO, UpdateCardDTO, CardDTO> {

}
