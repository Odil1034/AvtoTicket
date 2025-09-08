package uz.pdp.AutoTicket.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.request.UserCreateDTO;
import uz.pdp.AutoTicket.dto.request.auth.RefreshTokenRequestDTO;
import uz.pdp.AutoTicket.dto.request.auth.TokenRequestDTO;
import uz.pdp.AutoTicket.dto.request.auth.TokenResponseDTO;
import uz.pdp.AutoTicket.dto.response.user.UserResponseDTO;
import uz.pdp.AutoTicket.service.UserService;
import uz.pdp.AutoTicket.service.token.TokenService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.AutoTicket.utils.Constants;

@RestController
@RequestMapping(Constants.BASE_PATH + "auth")
@RequiredArgsConstructor
public class AuthController {

    private final TokenService tokenService;
    private final UserService userService;

    @PostMapping("/token")
    public ResponseEntity<Response<TokenResponseDTO>> token(@RequestBody TokenRequestDTO dto) {
        return ResponseEntity.ok(tokenService.generateToken(dto.username(), dto.password()));
    }

    @PostMapping("/create")
    public ResponseEntity<Response<UserResponseDTO>> register(@Valid @RequestBody UserCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(dto));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<Response<TokenResponseDTO>> refreshToken(@Valid @RequestBody RefreshTokenRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tokenService.refreshToken(dto.refreshToken()));
    }
}
