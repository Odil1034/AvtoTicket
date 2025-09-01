package uz.pdp.AutoTicket.controller.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.auth.TokenRequestDTO;
import uz.pdp.AutoTicket.dto.auth.TokenResponseDTO;
import uz.pdp.AutoTicket.dto.user.UserCreateDTO;
import uz.pdp.AutoTicket.dto.user.UserResponseDTO;
import uz.pdp.AutoTicket.service.UserService;
import uz.pdp.AutoTicket.service.token.TokenService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class RegisterController {

    private final TokenService tokenService;
    private final UserService userService;

    @GetMapping("/token")
    public ResponseEntity<Response<TokenResponseDTO>> token(@RequestBody TokenRequestDTO dto) {
        return ResponseEntity.ok(tokenService.generateToken(dto));
    }

    @PostMapping("/signup")
    public ResponseEntity<Response<UserResponseDTO>> register(@RequestBody UserCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(dto));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<Response<UserResponseDTO>> refreshToken(@RequestBody UserCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(dto));
    }

}
