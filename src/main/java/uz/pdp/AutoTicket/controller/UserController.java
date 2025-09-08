package uz.pdp.AutoTicket.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.ChangePasswordDTO;
import uz.pdp.AutoTicket.dto.response.user.UserResponseDTO;
import uz.pdp.AutoTicket.service.UserService;
import uz.pdp.AutoTicket.utils.Constants;

/**
 * @author Baxriddinov Odiljon
 * @since 02/09/2025 21:33
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.BASE_PATH + "user")
public class UserController {

    private final UserService userService;

    @GetMapping("/change-password")
    public ResponseEntity<Response<Boolean>> changePassword(@Valid @RequestBody ChangePasswordDTO dto) {
        return ResponseEntity.ok(userService.changePassword(dto));
    }

    @GetMapping("/me")
    public ResponseEntity<Response<UserResponseDTO>> findMe() {
        return ResponseEntity.ok(userService.findMe());
    }


}
