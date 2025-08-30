package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uz.pdp.AvtoTicket.dto.card.CardResponseDTO;
import uz.pdp.AvtoTicket.dto.card.CreateCardDTO;
import uz.pdp.AvtoTicket.dto.card.UpdateCardDTO;
import uz.pdp.AvtoTicket.entity.card.Card;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {

    Card toEntity(CreateCardDTO dto);

    Card toEntity(CardResponseDTO dto);

    CardResponseDTO toDTO(Card card);

    List<CardResponseDTO> toDTOList(List<Card> card);

    void toUpdate(@MappingTarget Card card, UpdateCardDTO dto);
}
