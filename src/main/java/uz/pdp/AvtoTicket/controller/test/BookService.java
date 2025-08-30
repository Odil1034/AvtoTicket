package uz.pdp.AvtoTicket.controller.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.AvtoTicket.service.BaseService;

import java.util.List;

public interface BookService extends BaseService<Book, BookCreateDTO, BookUpdateDTO, BookResponseDTO> {

    @Service
    @RequiredArgsConstructor
    class BookServiceImp implements BookService{

        private final BookMapper bookMapper;
        private final BookRepository bookRepository;

        @Override
        public BookResponseDTO create(BookCreateDTO dto) {
            Book entity = bookMapper.toEntity(dto);
            System.out.println(entity);
            Book save = bookRepository.save(entity);
//            return bookMapper.toDTO(save);
            return new BookResponseDTO(save.getId(), save.getTitle(), save.getAuthor(), save.getCountOfPage());
        }

        @Override
        public BookResponseDTO getById(Long id) {
            return null;
        }

        @Override
        public List<BookResponseDTO> getAll() {
            return List.of();
        }

        @Override
        public boolean delete(Long id) {
            return false;
        }

        @Override
        public BookResponseDTO update(Long id, BookUpdateDTO dto) {
            return null;
        }

        @Override
        public Book findById(Long id) {
            return null;
        }
    }
}
