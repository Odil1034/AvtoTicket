package uz.pdp.AvtoTicket.controller.test;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.AvtoTicket.dto.ApiResponse;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse<BookResponseDTO>> getBookByID(@PathVariable Long id) {
        BookResponseDTO byId = bookService.getById(id);
        return ApiResponse.success(byId);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<BookResponseDTO>> createBook(@RequestBody BookCreateDTO dto) {
        BookResponseDTO createdBook = bookService.create(dto);
        return ApiResponse.success(createdBook, "Book is created successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<BookResponseDTO>> updateBookById(@PathVariable Long id, @RequestBody BookUpdateDTO dto) {
        BookResponseDTO update = bookService.update(id, dto);
        return ApiResponse.success(update, "Book is updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Boolean>> deleteById(@PathVariable Long id) {
        boolean delete = bookService.delete(id);
        return ApiResponse.success(delete, "Book is deleted successfully");
    }
}
