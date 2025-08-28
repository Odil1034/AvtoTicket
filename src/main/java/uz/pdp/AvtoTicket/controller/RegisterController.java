package uz.pdp.AvtoTicket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.AvtoTicket.dto.ApiResponse;
import uz.pdp.AvtoTicket.dto.register.LoginDTO;
import uz.pdp.AvtoTicket.dto.register.SignUpDTO;
import uz.pdp.AvtoTicket.dto.user.UserResponseDTO;
import uz.pdp.AvtoTicket.service.userService.UserService;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;

    @GetMapping("/login")
    public ApiResponse<UserResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        UserResponseDTO user = userService.login(loginDTO);
        return ApiResponse.success(user).getBody();
    }

    @PostMapping("/signup")
    public ApiResponse<UserResponseDTO> signUp(@RequestBody SignUpDTO signUpDTO) {
        UserResponseDTO user = userService.signUp(signUpDTO);
        return ApiResponse.success(user, "User successfully created ✔✔✔").getBody();
    }

}
