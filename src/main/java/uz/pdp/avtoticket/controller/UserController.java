package uz.pdp.avtoticket.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.avtoticket.dto.Response;
import uz.pdp.avtoticket.dto.request.ChangePasswordDTO;
import uz.pdp.avtoticket.dto.response.user.UserResponseDTO;
import uz.pdp.avtoticket.service.UserService;
import uz.pdp.avtoticket.utils.Constants;

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
