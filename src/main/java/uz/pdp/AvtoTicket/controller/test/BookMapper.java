package uz.pdp.AvtoTicket.controller.test;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book toEntity(BookCreateDTO dto);
//
//    @Mapping(target = "bookId", source = "id")
//    BookResponseDTO toDTO(Book book);

}
