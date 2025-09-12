package uz.pdp.avtoticket.mapper;

import org.mapstruct.Mapper;
import uz.pdp.avtoticket.dto.request.card.CreateCardDTO;
import uz.pdp.avtoticket.dto.request.card.UpdateCardDTO;
import uz.pdp.avtoticket.dto.response.card.CardResponseDTO;
import uz.pdp.avtoticket.entity.Card;

/**
 * @author Baxriddinov Odiljon
 * @since 12/09/2025 08:43
 */
@Mapper(componentModel = "spring")
public interface CardMapper extends GenericMapper<Card, CardResponseDTO, CreateCardDTO, UpdateCardDTO> {

}
