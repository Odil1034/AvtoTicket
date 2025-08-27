package uz.pdp.AvtoTicket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<UserResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        UserResponseDTO user = userService.login(loginDTO);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/signup")
    public ResponseEntity<Boolean> signUp(@RequestBody SignUpDTO signUpDTO) {
        boolean b = userService.signUp(signUpDTO);
        return ResponseEntity.ok(b);
    }
}
