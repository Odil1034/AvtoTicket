package uz.pdp.AvtoTicket.mapper;

import org.mapstruct.Mapper;
import uz.pdp.AvtoTicket.dto.response.CardDTO;
import uz.pdp.AvtoTicket.entity.card.Card;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper extends EntityMapper<CardDTO, Card> {

    @Override
    Card toEntity(CardDTO dto);

    @Override
    CardDTO toDto(Card entity);

    @Override
    List<Card> toEntity(List<CardDTO> list);

    @Override
    List<CardDTO> toDto(List<Card> list);
}
