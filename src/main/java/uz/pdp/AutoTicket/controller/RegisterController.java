package uz.pdp.AutoTicket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.auth.RefreshTokenRequestDTO;
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

    @GetMapping("/tokens")
    public ResponseEntity<Response<TokenResponseDTO>> login(@RequestBody TokenRequestDTO dto) {
        return ResponseEntity.ok(tokenService.generateToken(dto));
    }

    @GetMapping("/refresh-token")
    public ResponseEntity<Response<TokenResponseDTO>> refreshToken(@RequestBody RefreshTokenRequestDTO dto) {
        return ResponseEntity.ok(tokenService.refreshToken(dto));
    }

    @PostMapping("/signup")
    public ResponseEntity<Response<UserResponseDTO>> register(@RequestBody UserCreateDTO userCreateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userCreateDTO));
    }

}
