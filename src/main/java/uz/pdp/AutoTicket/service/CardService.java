package uz.pdp.AutoTicket.service;

import jakarta.validation.constraints.NotNull;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.card.CreateCardDTO;
import uz.pdp.AutoTicket.dto.request.card.UpdateCardDTO;
import uz.pdp.AutoTicket.dto.response.card.CardResponseDTO;
import uz.pdp.AutoTicket.entity.Card;
import uz.pdp.AutoTicket.service.markers.GenericCruidService;

import java.util.List;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 13:22
 */
public interface CardService
        extends GenericCruidService<Long, Card, CardResponseDTO, CreateCardDTO, UpdateCardDTO> {

    boolean validateCard(CreateCardDTO dto);

    Response<List<CardResponseDTO>> getUserCards(@NotNull Long userId);

}
