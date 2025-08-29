package uz.pdp.AvtoTicket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;

    public static <T> ResponseEntity<ApiResponse<T>> success(T data, String message) {
        return ResponseEntity.ok(new ApiResponse<>(true, message, data));
    }

    public static <T> ResponseEntity<ApiResponse<T>> success(String message, HttpStatus status) {
        return ResponseEntity.status(status).body(new ApiResponse<>(true, message, null));
    }

    public static <T> ResponseEntity<ApiResponse<T>> success(T data) {
        return ResponseEntity.ok(new ApiResponse<>(true, "Success", data));
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(String message, HttpStatus status) {
        return ResponseEntity.status(status).body(new ApiResponse<>(false, message, null));
    }
}
