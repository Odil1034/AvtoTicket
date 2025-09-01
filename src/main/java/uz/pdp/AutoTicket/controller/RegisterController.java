package uz.pdp.AutoTicket.controller;

import lombok.RequiredArgsConstructor;
import uz.pdp.AutoTicket.dto.Response;
import uz.pdp.AutoTicket.dto.auth.TokenRequestDTO;
import uz.pdp.AutoTicket.dto.auth.TokenResponseDTO;
import uz.pdp.AutoTicket.dto.user.UserCreateDTO;
import uz.pdp.AutoTicket.dto.user.UserResponseDTO;
import uz.pdp.AutoTicket.service.token.TokenService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class RegisterController {

    private final TokenService tokenService;

    @GetMapping("/token")
    public ResponseEntity<UserResponseDTO> token(@RequestBody TokenRequestDTO dto) {
        Response<TokenResponseDTO> token = tokenService.generateToken(dto);
        return token;
    }

    @PostMapping("/signup")
    public Response<UserResponseDTO> register(@RequestBody UserCreateDTO signUpDTO) {
        UserResponseDTO user = userService.signUp(signUpDTO);
        return Response.success(user, "User successfully created ✔✔✔").getBody();
    }

}
